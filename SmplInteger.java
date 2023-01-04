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

	
	public SmplType lessThan(SmplType v)
	{
		if(v instanceof SmplInteger)
		{			
			SmplInteger i = (SmplInteger)v;
			
			Integer r1 = (Integer)getValue();
			Integer r2 = (Integer)i.getValue();		   			
			return new SmplBoolean(r1 < r2);
		}

		if(v instanceof SmplDouble)
		{			
			Double r1 =  Double.valueOf((Integer)getValue());
			Double r2 = (Double)v.getValue();
			return new SmplBoolean(r1 < r2);
		}

		throw new TypeException();
	}
	
	public SmplType greaterThan(SmplType v)
	{
		if(v instanceof SmplInteger)
		{			
			SmplInteger i = (SmplInteger)v;
			
			Integer r1 = (Integer)getValue();
			Integer r2 = (Integer)i.getValue();		   			
			return new SmplBoolean(r1 > r2);
		}

		if(v instanceof SmplDouble)
		{			
			Double r1 =  Double.valueOf((Integer)getValue());
			Double r2 = (Double)v.getValue();
			return new SmplBoolean(r1 > r2);
		}

		throw new TypeException();

	}

	public SmplType greaterThanOrEqual(SmplType v)
	{
				if(v instanceof SmplInteger)
		{			
			SmplInteger i = (SmplInteger)v;
			
			Integer r1 = (Integer)getValue();
			Integer r2 = (Integer)i.getValue();		   			
			return new SmplBoolean(r1 >= r2);
		}

		if(v instanceof SmplDouble)
		{			
			Double r1 =  Double.valueOf((Integer)getValue());
			Double r2 = (Double)v.getValue();
			return new SmplBoolean(r1 >= r2);
		}

		throw new TypeException();
	}

	public SmplType lessThanOrEqual(SmplType v)
	{
				if(v instanceof SmplInteger)
		{			
			SmplInteger i = (SmplInteger)v;
			
			Integer r1 = (Integer)getValue();
			Integer r2 = (Integer)i.getValue();		   			
			return new SmplBoolean(r1 <= r2);
		}

		if(v instanceof SmplDouble)
		{			
			Double r1 =  Double.valueOf((Integer)getValue());
			Double r2 = (Double)v.getValue();
			return new SmplBoolean(r1 <= r2);
		}

		throw new TypeException();
	}

	public SmplType notEqual(SmplType v)
	{
				if(v instanceof SmplInteger)
		{			
			SmplInteger i = (SmplInteger)v;
			
			Integer r1 = (Integer)getValue();
			Integer r2 = (Integer)i.getValue();		   			
			return new SmplBoolean(r1 != r2);
		}

		if(v instanceof SmplDouble)
		{			
			Double r1 =  Double.valueOf((Integer)getValue());
			Double r2 = (Double)v.getValue();
			return new SmplBoolean(r1 != r2);
		}

		throw new TypeException();
	}
	
	public SmplType areEqual(SmplType v)
	{
		if(v instanceof SmplInteger)
		{			
			SmplInteger i = (SmplInteger)v;
			
			Integer r1 = (Integer)getValue();
			Integer r2 = (Integer)i.getValue();		   			
			return new SmplBoolean(r1 == r2);
		}

		if(v instanceof SmplDouble)
		{			
			Double r1 =  Double.valueOf((Integer)getValue());
			Double r2 = (Double)v.getValue();
			return new SmplBoolean(r1 == r2);
		}

		throw new TypeException();
	}

}
