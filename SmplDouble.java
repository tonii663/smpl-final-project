public class SmplDouble extends SmplType<Double>
{
	public SmplDouble(Double value)
	{
		super(value);
	}
	
	public SmplType isEqu(SmplType v)
	{
		return areEqual(v);
	}

	public SmplType isEqv(SmplType v)
	{
		if(v instanceof SmplDouble)
		{			
			SmplDouble i = (SmplDouble)v;

			double r1 = (Double)i.getValue();
			double r2 = (Double)getValue();
			
			return new SmplBoolean(r1 == r2);
		}
		
		return new SmplBoolean(false);
	}
	
	public SmplType add(SmplType v)
	{
		if(v instanceof SmplInteger)
		{
			Double result = Double.valueOf((Integer)(v.getValue())) + (Double)getValue();
			return new SmplDouble(result);
		}

		if(v instanceof SmplDouble)
		{
			Double result = (Double)getValue() + (Double)v.getValue();
			return new SmplDouble(result);
		}

		throw new TypeException();
	}

	public SmplType sub(SmplType v)
	{
		if(v instanceof SmplInteger)
		{
			Double result = Double.valueOf((Integer)(v.getValue())) - (Double)getValue();
			return new SmplDouble(result);
		}

		if(v instanceof SmplDouble)
		{
			Double result = (Double)getValue() - (Double)v.getValue();
			return new SmplDouble(result);
		}

		throw new TypeException();
	}

	public SmplType mul(SmplType v)
	{
		if(v instanceof SmplInteger)
		{
			Double result = Double.valueOf((Integer)(v.getValue())) * (Double)getValue();
			return new SmplDouble(result);
		}

		if(v instanceof SmplDouble)
		{
			Double result = (Double)getValue() * (Double)v.getValue();
			return new SmplDouble(result);
		}

		throw new TypeException();
	}

	public SmplType div(SmplType v)
	{
		if(v instanceof SmplInteger)
		{
			Double result = Double.valueOf((Integer)(v.getValue())) / (Double)getValue();
			return new SmplDouble(result);
		}

		if(v instanceof SmplDouble)
		{
			Double result = (Double)getValue() / (Double)v.getValue();
			return new SmplDouble(result);
		}

		throw new TypeException();
	}

	public SmplType lessThan(SmplType v)
	{			
		if(v instanceof SmplDouble)
		{			
			Double r1 = (Double)getValue();
			Double r2 = (Double)v.getValue();
			return new SmplBoolean(r1 < r2);
		}

		if(v instanceof SmplInteger)
		{
			Double r1 = (Double)getValue();
			Double r2 = Double.valueOf((Integer)v.getValue());
			return new SmplBoolean(r1 < r2);
		}

		throw new TypeException();
	}
	
	public SmplType greaterThan(SmplType v)
	{
		if(v instanceof SmplDouble)
		{			
			Double r1 = (Double)getValue();
			Double r2 = (Double)v.getValue();
			return new SmplBoolean(r1 > r2);
		}

		if(v instanceof SmplInteger)
		{
			Double r1 = (Double)getValue();
			Double r2 = Double.valueOf((Integer)v.getValue());
			return new SmplBoolean(r1 > r2);
		}

		throw new TypeException();
	}

	public SmplType greaterThanOrEqual(SmplType v)
	{
		if(v instanceof SmplDouble)
		{			
			Double r1 = (Double)getValue();
			Double r2 = (Double)v.getValue();
			return new SmplBoolean(r1 >= r2);
		}

		if(v instanceof SmplInteger)
		{
			Double r1 = (Double)getValue();
			Double r2 = Double.valueOf((Integer)v.getValue());
			return new SmplBoolean(r1 >= r2);
		}

		throw new TypeException();

	}

	public SmplType lessThanOrEqual(SmplType v)
	{
		if(v instanceof SmplDouble)
		{			
			Double r1 = (Double)getValue();
			Double r2 = (Double)v.getValue();
			return new SmplBoolean(r1 <= r2);
		}

		if(v instanceof SmplInteger)
		{
			Double r1 = (Double)getValue();
			Double r2 = Double.valueOf((Integer)v.getValue());
			return new SmplBoolean(r1 <= r2);
		}

		throw new TypeException();
	}

	public SmplType notEqual(SmplType v)
	{
		if(v instanceof SmplDouble)
		{			
			Double r1 = (Double)getValue();
			Double r2 = (Double)v.getValue();
			return new SmplBoolean(r1 != r2);
		}

		if(v instanceof SmplInteger)
		{
			Double r1 = (Double)getValue();
			Double r2 = Double.valueOf((Integer)v.getValue());
			return new SmplBoolean(r1 != r2);
		}

		throw new TypeException();
	}
	
	public SmplType areEqual(SmplType v)
	{
		if(v instanceof SmplDouble)
		{			
			double r1 = (Double)getValue();
			double r2 = (Double)v.getValue();
			return new SmplBoolean(r1 == r2);
		}

		if(v instanceof SmplInteger)
		{
			double r1 = (Double)getValue();
			double r2 = Double.valueOf((Integer)v.getValue());
			return new SmplBoolean(r1 == r2);
		}
		
		throw new TypeException();
	}


}
