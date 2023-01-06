public class ExpRead extends Exp
{	
	public ExpRead()
	{
		super("read");
	}

	public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException
	{
		return v.visitExpRead(this, state);
	}
}
