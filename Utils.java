public class Utils
{
	public static Boolean isTrue(SmplType t)
	{
		if(t instanceof SmplBoolean)
		{
			return (Boolean)(t.getValue());
		}

		return false;
	}
}
