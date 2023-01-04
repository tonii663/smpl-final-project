public class ExpLit extends Exp
{
	private Object value;
	private String smplType;

	
	public ExpLit(Object value, String type)
	{
		super("lit");		
		this.smplType = type;
		this.value = value;
	}

	public String getType()
	{
		return smplType;
	}

	public Object getValue()
	{
		return value;
	}
	
	public <S, T> T visit(Visitor<S, T> v, S arg)
	{
		return v.visitExpLit(this, arg);
    }

}
