public class ExpPrintln extends Exp
{	
	public ExpPrintln(Exp exp)
	{
		super("println", exp);
	}

	public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException
	{
		return v.visitExpPrintln(this, state);
	}
}
