public class ExpMul extends ExpBinaryOperator
{
    public ExpMul(Exp e1, Exp e2)
	{
		super("*", e1, e2);
    }

    public int visit(Visitor v)
	{
		return v.visitExpMul(this);
    }
}
