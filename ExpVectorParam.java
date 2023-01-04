public class ExpVectorParam extends Exp
{
	private String type;
	private String iter;	
	
	public ExpVectorParam(Exp e)
	{
		super("vector-param", e);

		this.type = "value";
	}

	public ExpVectorParam(Exp n, String iter, Exp eval)
	{
		super("vector-param", n, eval);
		this.type = "func";
		this.iter = iter;
	}

	public String getType()
	{
		return type;
	}

	public String getIter()
	{
		return iter;
	}
	
	public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException
	{
		return v.visitExpVectorParam(this, arg);
    }

}
