public class ExpSub extends ExpBinaryOperator
{

    public ExpSub(Exp e1, Exp e2)
	{
		super("-", e1, e2);
    }

    public int visit(Visitor v)
	{
		return v.visitExpSub(this);
    }

}

