import java.util.*;

public class Evaluator implements Visitor
{
	public int visitSmplProgram(SmplProgram program)
	{
		return program.getSeq().visit(this);
	}
	
	public int visitExpAdd(ExpAdd exp)
	{
		int val1, val2;
		val1 = exp.getLeftExp().visit(this);
		val2 = exp.getRightExp().visit(this);
		return val1 + val2;
	}
	

	public int visitExpSub(ExpSub exp)
	{
		int val1, val2;
		val1 = exp.getLeftExp().visit(this);
		val2 = exp.getRightExp().visit(this);
		return val1 - val2;
	}
	
    public int visitExpMul(ExpMul exp)
	{
		int val1, val2;
		val1 = exp.getLeftExp().visit(this);
		val2 = exp.getRightExp().visit(this);
		return val1 * val2;
	}
	
    public int visitExpDiv(ExpDiv exp)
	{
		int val1, val2;
		val1 = exp.getLeftExp().visit(this);
		val2 = exp.getRightExp().visit(this);
		return val1 / val2;

	}
	
    public int visitExpLit(ExpLit exp)
	{
		return exp.getVal();	
	}

}
