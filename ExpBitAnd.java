public class ExpBitAnd extends ExpBinaryOperator
{
	public ExpBitAnd(Exp e1, Exp e2)
	{
		super("bit-and", e1, e2);
	}

	public <S, T> T visit(Visitor<S, T> v, S state)  throws VisitException
	{
		return v.visitExpBitAnd(this, state);
    }

}
