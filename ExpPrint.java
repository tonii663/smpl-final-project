public class ExpPrint extends Exp
{	
	public ExpPrint(Exp exp)
	{
		super("print", exp);
	}

	public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException
	{
		return v.visitExpPrint(this, state);
	}
}
