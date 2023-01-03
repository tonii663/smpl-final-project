
public class SmplVector extends SmplType<Vector>
{

	public SmplVector(Vector value)
	{
		super(value);
	}

	
	public SmplType index(SmplType v)
	{
		if(v instanceof SmplInteger)
		{
			
			Integer i = (Integer)v.getValue();
			return ((Vector)getValue()).getAt(i);
		}

		System.out.println(v.getClass().getName());
		throw new TypeException();
	}

	public SmplType size()
	{
		return new SmplInteger(((Vector)getValue()).length());
	}
	
	public String toString()
	{
		String result = "[: ";

		Vector p = ((Vector)getValue());

		int length = p.length();
		for(int i = 0; i < length; i++)
		{
			result += p.get().get(i).toString();

			if(i < (length-1))
			{
				result += ", ";
			}
		}

		result += " :]";

		return result;
	}	
}


