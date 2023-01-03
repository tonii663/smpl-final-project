public abstract class SmplType<T>
{
	private T value;
	
	public SmplType(T value)
	{
		this.value = value;
	}

	public SmplType()
	{
		this.value = null;
	}

	public T getValue()
	{
		return value;
	}

	public SmplType add(SmplType v) throws TypeException
	{
		throw new TypeException();
	}

	public SmplType sub(SmplType v) throws TypeException
	{
		throw new TypeException();
	}

	public SmplType mul(SmplType v) throws TypeException
	{
		throw new TypeException();
	}
	
	public SmplType div(SmplType v) throws TypeException
	{
		throw new TypeException();
	}

	public SmplType mod(SmplType v) throws TypeException
	{
		throw new TypeException();
	}
	
	public SmplType and(SmplType v) throws TypeException
	{
		throw new TypeException();
	}
	
	public SmplType or(SmplType v) throws TypeException
	{
		throw new TypeException();
	}
	
	public SmplType not() throws TypeException
	{
		throw new TypeException();
	}

	public SmplType lessThan(SmplType v) throws TypeException
	{
		throw new TypeException();
	}

	
	public SmplType greaterThan(SmplType v) throws TypeException
	{
		throw new TypeException();
	}

	public SmplType greaterThanOrEqual(SmplType v) throws TypeException
	{
		throw new TypeException();
	}

	public SmplType lessThanOrEqual(SmplType v) throws TypeException
	{
		throw new TypeException();
	}

	public SmplType notEqual(SmplType v) throws TypeException
	{
		throw new TypeException();
	}
	
}
