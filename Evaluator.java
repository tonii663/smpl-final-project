import java.util.*;

public class Evaluator implements Visitor
{
	public Double visitSmplProgram(SmplProgram program)
	{
		return program.getSeq().visit(this);
	}

	public Double visitStatement(Statement stmt)
	{
		return stmt.getExp().visit(this);
	}
	
	public Double visitStatementSequence(StatementSequence seq)
	{
		ArrayList<Exp> stmts = seq.getSeq();

		Double result = 0.0;
		for(int stmtIndex = 0; stmtIndex < stmts.size(); stmtIndex++)
		{
			result = stmts.get(stmtIndex).visit(this);
		}
		return result;
	}

	public Double visitExpAdd(ExpAdd exp)
	{
		Double val1, val2;
		val1 = exp.getLeftExp().visit(this);
		val2 = exp.getRightExp().visit(this);
		return val1 + val2;
	}
	

	public Double visitExpSub(ExpSub exp)
	{
		Double val1, val2;
		val1 = exp.getLeftExp().visit(this);
		val2 = exp.getRightExp().visit(this);
		return val1 - val2;
	}
	
    public Double visitExpMul(ExpMul exp)
	{
		Double val1, val2;
		val1 = exp.getLeftExp().visit(this);
		val2 = exp.getRightExp().visit(this);
		return val1 * val2;
	}
	
    public Double visitExpDiv(ExpDiv exp)
	{
		Double val1, val2;
		val1 = exp.getLeftExp().visit(this);
		val2 = exp.getRightExp().visit(this);
		return val1 / val2;

	}

	public Double visitExpMod(ExpMod exp)
	{
		Double val1, val2;
		val1 = exp.getLeftExp().visit(this);
		val2 = exp.getRightExp().visit(this);
		return val1 % val2;

	}

    public Double visitExpLit(ExpLit exp)
	{
		return exp.getValue();
	}

}
