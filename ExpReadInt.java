public class ExpReadInt extends Exp
{	
	public ExpReadInt()
	{
		super("read");
	}

	public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException
	{
		return v.visitExpReadInt(this, state);
	}
}
