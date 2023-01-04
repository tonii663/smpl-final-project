import java.util.*;

public class Evaluator implements Visitor<Environment<SmplType>, SmplType>
{
	public Environment<SmplType> getDefaultState()
	{
		return Environment.makeGlobalEnv(SmplType.class);
    }
	
	public SmplType visitSmplProgram(SmplProgram program, Environment<SmplType> state)
	{
		SmplType result = program.getSeq().visit(this, state);
		return result;
	}
	
	public SmplType visitStatement(Statement stmt, Environment<SmplType> state)
	{
		return stmt.getExp().visit(this, state);
	}

	public SmplType visitStmtFuncDefinition(StmtFuncDefinition fd, Environment<SmplType> state)
	{
		Closure closure = new Closure(fd, state);
		state.putClosure(fd.getName(), closure);
		return new SmplNil();
	}

	public SmplType visitStatementDefinition(StatementDefinition def, Environment<SmplType> state)
	{
		SmplType result;
		result = def.getExp().visit(this, state);
		state.put(def.getId(), result);
		return result;
	}
	
	public SmplType visitStatementSequence(StatementSequence sseq, Environment<SmplType> state)
	{
		Statement s;
		ArrayList seq = sseq.getSeq();
		Iterator iter = seq.iterator();

		SmplType result = null;
		
		while(iter.hasNext()) {
			s = (Statement) iter.next();
			result = s.visit(this, state);
		}
		
		return result;
	}

	public SmplType visitExpFuncCall(ExpFuncCall exp, Environment<SmplType> state)
	{
		SmplType result;
		
		ArrayList<Exp> args = exp.getSubTrees();
		Closure closure = state.getClosure(exp.getName());
		StmtFuncDefinition fun = closure.getFunction();
		
		if(fun.getParamsCount() != args.size())
		{
			throw new UnboundVarException(fun.getName());
		}

		ArrayList<String> params = fun.getParams();
		ArrayList<SmplType> arguments = new ArrayList<SmplType>();

		for(int i = 0; i < fun.getParamsCount(); i++)
		{
			arguments.add(args.get(i).visit(this, state));
		}
		
		Environment<SmplType> child = new Environment<SmplType>(closure.getClosingEnv(),
																params, arguments);
		result = fun.getBody().visit(this, child);

		return result;
	}	

	public SmplType visitExpAdd(ExpAdd exp, Environment<SmplType> state)
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);
		
		return val1.add(val2);
	}	

	public SmplType visitExpSub(ExpSub exp, Environment<SmplType> state)
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);

		return val1.sub(val2);
	}
	
    public SmplType visitExpMul(ExpMul exp, Environment<SmplType> state)
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);

		return val1.mul(val2);
	}
	
    public SmplType visitExpDiv(ExpDiv exp, Environment<SmplType> state)
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);

		return val1.div(val2);
	}

	public SmplType visitExpMod(ExpMod exp, Environment<SmplType> state)
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);

		return val1.mod(val2);
	}

	public SmplType visitExpCmp(ExpCmp exp, Environment<SmplType> state)
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);

		switch(exp.getCmp())
		{
			case("GT"):
			{
				return val1.greaterThan(val2);
			}

			case("LT"):
			{
				return val1.lessThan(val2);
			}


			case("GE"):
			{
				return val1.greaterThanOrEqual(val2);	
			}


			case("LE"):
			{
				return val1.lessThanOrEqual(val2);				
			}


			case("NE"):
			{
				return val1.notEqual(val2);
			}


			case("EQUAL"):
			{
				return val1.areEqual(val2);				
			}

			default:
			{
				return null;
			}
		}		
	}

	public SmplType visitExpAnd(ExpAnd exp, Environment<SmplType> state)
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);
		
		return val1.and(val2);
	}

	public SmplType visitExpOr(ExpOr exp, Environment<SmplType> state)
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);
		
		return val1.or(val2);
	}

	public SmplType visitExpNot(ExpNot exp, Environment<SmplType> state)
	{
		SmplType val;
		val = exp.getExp().visit(this, state);		
		return val.not();
	}

	public SmplType visitExpPrint(ExpPrint exp, Environment<SmplType> state)
	{
		SmplType r = exp.getSubTree(0).visit(this, state);
		System.out.print(r.toString());
		return r;
	}

	public SmplType visitExpPrintln(ExpPrintln exp, Environment<SmplType> state)
	{
		SmplType r = exp.getSubTree(0).visit(this, state);
		System.out.println(r.toString());
		return r;
	}

	
    public SmplType visitExpVar(ExpVar exp, Environment<SmplType> state)
	{
		return state.get(exp.getVar());
	}	


	public SmplType visitExpOps(ExpOps exp, Environment<SmplType> state)
	{				
		switch(exp.getOp())
		{
			case("size"):
			{
				return exp.getSubTree(0).visit(this, state).size();
			}

			case("car"):
			{
				return exp.getSubTree(0).visit(this, state).car();
			}

			case("cdr"):
			{
				return exp.getSubTree(0).visit(this, state).cdr();
			}

			case("is-pair"):
			{
				return exp.getSubTree(0).visit(this, state).isPair();
			}

			case("index"):
			{
				return exp.getSubTree(0).visit(this, state).index(exp.getSubTree(0).visit(this, state));
			}
			
			case("equ"):
			{
				return exp.getSubTree(0).visit(this, state).isEqu(exp.getSubTree(1).visit(this, state));
			}

			default:
			{
				// TODO(afb) :: Error handling
				return null;
			}
		}
	}

	
	public SmplType visitExpVectorParamList(ExpVectorParamList exp,
											Environment<SmplType> state)
	{
		return new SmplRaw(exp.getValues());
	}
	
	public SmplType visitExpVectorParam(ExpVectorParam exp, Environment<SmplType> state)
	{
		ArrayList<SmplType> result = new ArrayList<>();

		String type = exp.getType();
		if(type == "value")
		{
			SmplType r = exp.getSubTree(0).visit(this, state);
			result.add(r);
		}
		else if(type == "func")
		{
			SmplType counter = exp.getSubTree(0).visit(this, state);
			if(counter instanceof SmplInteger)
			{
				Integer siz = (Integer)counter.getValue();
				Exp eval = exp.getSubTree(1);				
				String iter = exp.getIter();
				Environment<SmplType> child = new Environment<SmplType>(state);
				
				for(int i = 0; i < siz; i++)
				{
					child.put(iter, new SmplInteger(i));
					SmplType r = eval.visit(this, child);
					result.add(r);
				}
			}
		}
		
		return new SmplRaw(result);
	}
	
	public SmplType visitExpLit(ExpLit exp, Environment<SmplType> state)
	{
		switch(exp.getType())
		{
			case("smpl-integer"):
			{
				return new SmplInteger((Integer)exp.getValue());
			}

			case("smpl-double"):
			{
				return new SmplDouble((Double)exp.getValue());
			}

			case("smpl-boolean"):
			{
				return new SmplBoolean((Boolean)exp.getValue());
			}

			case("smpl-character"):
			{
				return new SmplCharacter((Character)exp.getValue());
			}

			case("smpl-pair"):
			{				
				ArrayList<Exp> r = (ArrayList<Exp>)(exp.getValue());
				Pair p = new Pair(r.get(0).visit(this, state),
								  r.get(1).visit(this, state));
				return new SmplPair(p);
			}
			
			case("smpl-vector"):
			{
				ArrayList<Exp> t1 = (ArrayList<Exp>)exp.getValue();
								
				ArrayList<SmplType> result = new ArrayList<>();
				
				for(Exp t2 : t1)
				{
					SmplType t3 = t2.visit(this, state);
					ArrayList<SmplType> t4 = (ArrayList<SmplType>)t3.getValue();

					for(SmplType t : t4)
					{
						result.add(t);
					}
				}

				return new SmplVector(new Vector(result));
			}

			case("smpl-list"):
			{				
				ArrayList<Exp> r = (ArrayList<Exp>)(exp.getValue());
				ArrayList<SmplType> result = new ArrayList<SmplType>();

				for(Exp a : r)
				{
					result.add(a.visit(this, state));
				}

				return new SmplList(new List(result));
			}

			default:
			{
				// TODO(afb) :: Error handling
				return null;
			}
		}		
	}  
}
