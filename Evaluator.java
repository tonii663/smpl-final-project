import java.util.*;
import java.io.*;

public class Evaluator implements Visitor<Environment<SmplType>, SmplType>
{
	private BufferedReader reader;

	public Evaluator()
	{
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Environment<SmplType> getDefaultState()
	{		
		return Environment.makeGlobalEnv(SmplType.class);		
	}
	
	public SmplType visitSmplProgram(SmplProgram program, Environment<SmplType> state)  throws VisitException
	{
		SmplType result = program.getSeq().visit(this, state);
		return result;
	}
	
	public SmplType visitStatement(Statement stmt, Environment<SmplType> state) throws VisitException
	{
		return stmt.getExp().visit(this, state);
	}

	public SmplType visitStmtFuncDefinition(StmtFuncDefinition fd, Environment<SmplType> state) throws VisitException
	{
		Closure closure = new Closure(fd, state);
		state.putClosure(fd.getName(), closure);
		return new SmplNil();
	}

	public SmplType visitStatementDefinition(StatementDefinition def, Environment<SmplType> state) throws VisitException
	{
		SmplType result;
		result = def.getExp().visit(this, state);
		state.put(def.getId(), result);
		return result;
	}

	public SmplType visitExpAssign(ExpAssign exp, Environment<SmplType> state) throws VisitException
	{
		SmplType result;		
		result = exp.getExp().visit(this, state);		
		state.reassign(exp.getId(), result);
		return result;
	}

	public SmplType visitStatementSequence(StatementSequence sseq, Environment<SmplType> state) throws VisitException
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

	public SmplType visitExpFuncCall(ExpFuncCall exp, Environment<SmplType> state) throws VisitException
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

	public SmplType visitExpBitAnd(ExpBitAnd exp, Environment<SmplType> state) throws VisitException
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);
		
		return val1.bitwiseAnd(val2);
	}	
	
	public SmplType visitExpBitOr(ExpBitOr exp, Environment<SmplType> state) throws VisitException
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);
		
		return val1.bitwiseOr(val2);
	}	
	
	public SmplType visitExpBitNot(ExpBitNot exp, Environment<SmplType> state) throws VisitException
	{
		SmplType val;
		val = exp.getExp().visit(this, state);		
		return val.bitwiseNot();
	}	

	
	public SmplType visitExpAdd(ExpAdd exp, Environment<SmplType> state) throws VisitException
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);
		
		return val1.add(val2);
	}	

	public SmplType visitExpSub(ExpSub exp, Environment<SmplType> state) throws VisitException
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);

		return val1.sub(val2);
	}
	
    public SmplType visitExpMul(ExpMul exp, Environment<SmplType> state) throws VisitException
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);

		return val1.mul(val2);
	}
	
    public SmplType visitExpDiv(ExpDiv exp, Environment<SmplType> state) throws VisitException
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);

		return val1.div(val2);
	}

	public SmplType visitExpMod(ExpMod exp, Environment<SmplType> state) throws VisitException
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);

		return val1.mod(val2);
	}

	public SmplType visitExpCmp(ExpCmp exp, Environment<SmplType> state) throws VisitException
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

	public SmplType visitExpAnd(ExpAnd exp, Environment<SmplType> state) throws VisitException
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);
		
		return val1.and(val2);
	}

	public SmplType visitExpOr(ExpOr exp, Environment<SmplType> state) throws VisitException
	{
		SmplType val1, val2;
		val1 = exp.getLeftExp().visit(this, state);
		val2 = exp.getRightExp().visit(this, state);
		
		return val1.or(val2);
	}

	public SmplType visitExpNot(ExpNot exp, Environment<SmplType> state) throws VisitException
	{
		SmplType val;
		val = exp.getExp().visit(this, state);		
		return val.not();
	}

	public SmplType visitExpPrint(ExpPrint exp, Environment<SmplType> state) throws VisitException
	{
		SmplType r = exp.getSubTree(0).visit(this, state);
		System.out.print(r.toString());
		return r;
	}
	
	public SmplType visitExpPrintln(ExpPrintln exp, Environment<SmplType> state) throws VisitException
	{
		SmplType r = exp.getSubTree(0).visit(this, state);
		System.out.println(r.toString());
		return r;
	}


	public SmplType visitExpRead(ExpRead exp, Environment<SmplType> state) throws VisitException
	{
		try
		{
			SmplType result = new SmplString(reader.readLine());
			return result;
		}
		catch(IOException io)
		{
			return new SmplNil();
		}
		
		
	}

	public SmplType visitExpReadInt(ExpReadInt exp, Environment<SmplType> state) throws VisitException
	{
		try
		{
			String result = reader.readLine();
			return new SmplInteger(Integer.parseInt(result));
		}
		catch(IOException io)
		{
			return new SmplNil();
		}						
	}

	
    public SmplType visitExpVar(ExpVar exp, Environment<SmplType> state) throws VisitException
	{
		return state.get(exp.getVar());
	}	


	public SmplType visitExpOps(ExpOps exp, Environment<SmplType> state) throws VisitException
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

			case("eqv"):
			{
				return exp.getSubTree(0).visit(this, state).isEqv(exp.getSubTree(1).visit(this, state));
			}

			case("equ"):
			{
				return exp.getSubTree(0).visit(this, state).isEqu(exp.getSubTree(1).visit(this, state));
			}
			
			case("substr"):
			{
				return exp.getSubTree(0).visit(this, state)
				.substr(exp.getSubTree(1).visit(this, state),
						exp.getSubTree(2).visit(this, state));
			}

			default:
			{
				// TODO(afb) :: Error handling
				return null;
			}
		}
	}

	
	public SmplType visitExpVectorParamList(ExpVectorParamList exp,
											Environment<SmplType> state) throws VisitException
	{
		return new SmplRaw(exp.getValues());
	}

	public SmplType visitExpSeq(ExpSeq exp,
								Environment<SmplType> state) throws VisitException
	{
		SmplType result = new SmplNil();

		ArrayList<Exp> exprs = exp.getSubTrees();
		for(Exp e : exprs )
		{
			result = e.visit(this, state);
		}

		return result;
	}

	public SmplType visitExpVectorParam(ExpVectorParam exp, Environment<SmplType> state) throws VisitException
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
	
	public SmplType visitExpLit(ExpLit exp, Environment<SmplType> state) throws VisitException
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
			
			case("smpl-string"):
			{
				return new SmplString((String)exp.getValue());
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

	@Override
	public SmplType visitExpBind(ExpBind expBind, Environment<SmplType> arg) throws VisitException {
		Exp ep = expBind.getExp();
		SmplType result = ep.visit(this, arg);
		arg.put(expBind.getId(), result);
		return result;
	}

	@Override
	public SmplType visitExpLet(ExpLet expLet, Environment<SmplType> arg) throws VisitException {
	
		Environment letenv = new Environment(arg);
		
		// evaluate bindings with new environment
		ArrayList<ExpBind> bindings = expLet.getBinds();
		for (int i = 0; i < bindings.size(); i++) {
			bindings.get(i).visit(this, letenv);
		}

		return expLet.getBody().visit(this, letenv);
	}

	@Override
	public SmplType visitExpConcat(ExpConcat expConcat, Environment<SmplType> arg) throws VisitException {
		return expConcat.getLeft().visit(this, arg).concat(expConcat.getRight().visit(this, arg));
	}

	@Override
	public SmplType visitExpClause(ExpClause clause, Environment<SmplType> state) throws VisitException
	{
		if(clause.getPredicate() != null){
			return clause.getPredicate().visit(this, state);
		}
		return null;
	}

	@Override
	public SmplType visitExpCase(ExpCase cases, Environment<SmplType> state) throws VisitException
	{
		ArrayList<ExpClause> caseList = cases.getCaseList();
		for(int c=0; c<caseList.size(); c++) {

			ExpCmp caseVal = caseList.get(c).getPredicate();
			String res = "false";
			if (caseList.get(c).isElse() == false){
				SmplType result = visitExpCmp(caseVal, state);
				res = String.valueOf(result);
			}

			if ( res == "true" || caseList.get(c).isElse() == true ){
				return caseList.get(c).getConsequent().visit(this, state);
			}
		}
		return null;
	}
}
