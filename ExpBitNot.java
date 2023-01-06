public class ExpBitNot extends ExpUnaryOperator
{
	public ExpBitNot(Exp exp)
	{
		super("bit-not", exp);
    }

	
    public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException
	{
		return v.visitExpBitNot(this, state);
    }

}
