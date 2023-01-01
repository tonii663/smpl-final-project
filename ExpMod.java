public class ExpMod extends ExpBinaryOperator
{

    public ExpMod(Exp e1, Exp e2)
	{
		super("%", e1, e2);
    }

    public Double visit(Visitor v)
	{
		return v.visitExpMod(this);
    }

}

