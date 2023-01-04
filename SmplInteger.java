public class SmplInteger extends SmplType<Integer>
{
	public SmplInteger(Integer value)
	{
		super(value);
	}

	public SmplType add(SmplType v)
	{
		if(v instanceof SmplInteger)
		{
			Integer result = (Integer)getValue() + (Integer)v.getValue();
			return new SmplInteger(result);
		}

		if(v instanceof SmplDouble)
		{
			Double result = Double.valueOf((Integer)getValue()) + (Double)v.getValue();
			return new SmplDouble(result);
		}

		throw new TypeException();
	}

	public SmplType mul(SmplType v)
	{
		if(v instanceof SmplInteger)
		{
			Integer result = (Integer)getValue() * (Integer)v.getValue();
			return new SmplInteger(result);
		}

		if(v instanceof SmplDouble)
		{
			Double result = Double.valueOf((Integer)getValue()) * (Double)v.getValue();
			return new SmplDouble(result);
		}

		throw new TypeException();
	}

	public SmplType div(SmplType v)
	{
		if(v instanceof SmplInteger)
		{
			Integer result = (Integer)getValue() / (Integer)v.getValue();
			return new SmplInteger(result);
		}

		if(v instanceof SmplDouble)
		{
			Double result = Double.valueOf((Integer)getValue()) / (Double)v.getValue();
			return new SmplDouble(result);
		}

		throw new TypeException();
	}

	public SmplType sub(SmplType v)
	{
		if(v instanceof SmplInteger)
		{
			Integer result = (Integer)getValue() - (Integer)v.getValue();
			return new SmplInteger(result);
		}

		if(v instanceof SmplDouble)
		{
			Double result = Double.valueOf((Integer)getValue()) - (Double)v.getValue();
			return new SmplDouble(result);
		}

		throw new TypeException();
	}

	public SmplType mod(SmplType v)
	{
		if(v instanceof SmplInteger)
		{
			Integer result = (Integer)getValue() % (Integer)v.getValue();
			return new SmplInteger(result);
		}

		throw new TypeException();
	}

	public SmplType isEqu(SmplType v)
	{
		if(v instanceof SmplInteger)
		{			
			SmplInteger i = (SmplInteger)v;

			Integer r1 = (Integer)i.getValue();
			Integer r2 = (Integer)getValue();
			
			return new SmplBoolean(r1 == r2);
		}
		
		return new SmplBoolean(false);
	}

}
