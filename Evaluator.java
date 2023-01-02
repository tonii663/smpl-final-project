import java.util.*;

public class Evaluator implements Visitor<Environment<Object>, Object>
{
	public Environment<Object> getDefaultState()
	{
		return Environment.makeGlobalEnv(Object.class);
    }
	
	public Object visitSmplProgram(SmplProgram program, Environment<Object> state)
	{
		return program.getSeq().visit(this, state);
	}
	
	public Object visitStatement(Statement stmt, Environment<Object> state)
	{
		return stmt.getExp().visit(this, state);
	}

	public Object visitStatementDefinition(StatementDefinition def, Environment<Object> state)
	{
		Object result;
		result = def.getExp().visit(this, state);
		state.put(def.getId(), result);
		return result;
	}
	
	public Object visitStatementSequence(StatementSequence sseq, Environment<Object> state)
	{
		Statement s;
		ArrayList seq = sseq.getSeq();
		Iterator iter = seq.iterator();

		Object result = 0.0;
		
		while(iter.hasNext()) {
			s = (Statement) iter.next();
			result = s.visit(this, state);
		}
		
		return result;
	}

	public Object visitExpAdd(ExpAdd exp, Environment<Object> state)
	{
		Double val1, val2;
		val1 = Double.valueOf(exp.getLeftExp().visit(this, state).toString());
		val2 = Double.valueOf(exp.getRightExp().visit(this, state).toString());
		return val1 + val2;
	}
	

	public Object visitExpSub(ExpSub exp, Environment<Object> state)
	{
		Double val1, val2;
		val1 = Double.valueOf(exp.getLeftExp().visit(this, state).toString());
		val2 = Double.valueOf(exp.getRightExp().visit(this, state).toString());
		return val1 - val2;
	}
	
    public Object visitExpMul(ExpMul exp, Environment<Object> state)
	{
		Double val1, val2;
		val1 = Double.valueOf(exp.getLeftExp().visit(this, state).toString());
		val2 = Double.valueOf(exp.getRightExp().visit(this, state).toString());
		return val1 * val2;
	}
	
    public Object visitExpDiv(ExpDiv exp, Environment<Object> state)
	{
		Double val1, val2;
		val1 = Double.valueOf(exp.getLeftExp().visit(this, state).toString());
		val2 = Double.valueOf(exp.getRightExp().visit(this, state).toString());		
		return val1 / val2;

	}

	public Object visitExpMod(ExpMod exp, Environment<Object> state)
	{
		Double val1, val2;
		val1 = Double.valueOf(exp.getLeftExp().visit(this, state).toString());
		val2 = Double.valueOf(exp.getRightExp().visit(this, state).toString());
		return val1 % val2;

	}

    public Object visitExpLit(ExpLit exp, Environment<Object> state)
	{
		return exp.getValue();
	}
	
    public Object visitExpVar(ExpVar exp, Environment<Object> state)
	{
		return state.get(exp.getVar());
	}

	

}
