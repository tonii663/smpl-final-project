
public class SmplVector extends SmplType<Vector>
{

	public SmplVector(Vector value)
	{
		super(value);
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


