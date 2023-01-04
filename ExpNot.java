public class ExpNot extends ExpUnaryOperator
{

    public ExpNot(Exp e)
	{
		super("not", e);
    }

    public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException
	{
		return v.visitExpNot(this, state);
    }

}

