public class ExpOps extends Exp
{
	private String operation;
	
	public ExpOps(Exp exp, String op)
	{
		super("type-op", exp);
		this.operation = op;
    }

	public String getOp()
	{
		return operation;
	}
	
    public <S, T> T visit(Visitor<S, T> v, S state)
	{
		return v.visitExpOps(this, state);
    }
}
