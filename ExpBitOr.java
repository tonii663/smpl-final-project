public class ExpBitOr extends ExpBinaryOperator
{
	public ExpBitOr(Exp e1, Exp e2)
	{
		super("bit-or", e1, e2);
	}

	public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException
	{
		return v.visitExpBitOr(this, state);
    }

}
