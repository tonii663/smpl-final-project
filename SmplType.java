public abstract class SmplType<T> extends ExpLit
{
	protected String type;

	public SmplType(T value, String type)
	{
		super(value.toString());
		this.value = value;
		this.type = type;
	}
	
	public String getType()
	{
		return type;
	}

    public abstract Double getValue(); 
}
