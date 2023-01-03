import java.util.*;

public class Evaluator implements Visitor<Environment<SmplType>, SmplType>
{
	public Environment<SmplType> getDefaultState()
	{
		return Environment.makeGlobalEnv(SmplType.class);
    }
	
	public SmplType visitSmplProgram(SmplProgram program, Environment<SmplType> state)
	{
		return program.getSeq().visit(this, state);
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

			default:
			{
				// TODO(afb) :: Error handling
				return null;
			}
		}
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
				ArrayList<Exp> r = (ArrayList<Exp>)(exp.getValue());
				ArrayList<SmplType> result = new ArrayList<SmplType>();

				for(Exp a : r)
				{
					result.add(a.visit(this, state));
				}

				return new SmplVector(new Vector(result));
			}

			default:
			{
				// TODO(afb) :: Error handling
				return null;
			}
		}
	}	   
}
