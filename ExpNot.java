public class ExpNot extends ExpUnaryOperator
{

    public ExpNot(Exp e)
	{
		super("not", e);
    }

    public <S, T> T visit(Visitor<S, T> v, S state)
	{
		return v.visitExpNot(this, state);
    }

}

