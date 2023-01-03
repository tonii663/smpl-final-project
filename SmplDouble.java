public class SmplDouble extends SmplType<Double>
{
	public SmplDouble(Double value)
	{
		super(value);
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

}
