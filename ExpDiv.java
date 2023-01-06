public class ExpDiv extends ExpBinaryOperator
{

    public ExpDiv(Exp e1, Exp e2)
	{
		super("/", e1, e2);
    }

    public <S, T> T visit(Visitor<S, T> v, S state)  throws VisitException
	{
		return v.visitExpDiv(this, state);
    }

}

