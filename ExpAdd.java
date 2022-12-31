public class ExpAdd extends ExpBinaryOperator
{

    public ExpAdd(Exp e1, Exp e2)
	{
		super("+", e1, e2);
    }

    public int visit(Visitor v)
	{
		return v.visitExpAdd(this);
    }

}

