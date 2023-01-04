public class ExpOps extends Exp
{
	private String operation;

	public ExpOps(String op, Exp... exp)
	{
		super("type-op", exp);
		this.operation = op;
    }

	public String getOp()
	{
		return operation;
	}
	
    public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException
	{
		return v.visitExpOps(this, state);
    }
}
