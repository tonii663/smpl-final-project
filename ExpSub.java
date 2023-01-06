public class ExpSub extends ExpBinaryOperator
{

    public ExpSub(Exp e1, Exp e2)
	{
		super("-", e1, e2);
    }

    public <S, T> T visit(Visitor<S, T> v, S state)  throws VisitException
	{
		return v.visitExpSub(this, state);
    }

}

