public class ExpMod extends ExpBinaryOperator
{

    public ExpMod(Exp e1, Exp e2)
	{
		super("%", e1, e2);
    }

    public <S, T> T visit(Visitor<S, T> v, S state)  throws VisitException
	{
		return v.visitExpMod(this, state);
    }

}

