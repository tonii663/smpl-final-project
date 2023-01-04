public class ExpOr extends ExpBinaryOperator
{

    public ExpOr(Exp e1, Exp e2)
	{
		super("or", e1, e2);
    }

    public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException
	{
		return v.visitExpOr(this, state);
    }

}
