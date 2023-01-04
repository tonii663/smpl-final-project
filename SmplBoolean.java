public class SmplBoolean extends SmplType<Boolean>
{
	public SmplBoolean(Boolean value)
	{
		super(value);
	}

	public SmplType and(SmplType v)
	{
		if(v instanceof SmplBoolean)
		{
			Boolean result = (Boolean)getValue() && (Boolean)v.getValue();
			return new SmplBoolean(result);
		}
		
		throw new TypeException();
	}
	
	public SmplType or(SmplType v)
	{
		if(v instanceof SmplBoolean)
		{
			Boolean result = (Boolean)getValue() || (Boolean)v.getValue();
			return new SmplBoolean(result);
		}

		throw new TypeException();
	}
	
	public SmplType not()
	{
		Boolean result = !(Boolean)getValue();
		return new SmplBoolean(result);
	}

}
