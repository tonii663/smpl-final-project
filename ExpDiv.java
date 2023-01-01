public class ExpDiv extends ExpBinaryOperator
{

    public ExpDiv(Exp e1, Exp e2)
	{
		super("/", e1, e2);
    }

    public Double visit(Visitor v)
	{
		return v.visitExpDiv(this);
    }

}

