public class SmplNumber<T> extends SmplType
{
    public SmplNumber(T value, String type)
	{
		super(value, type);
    }

    public Double getValue()
	{
		return Double.parseDouble(getLit().toString());
	}
	
}
