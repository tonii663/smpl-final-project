public class Pair
{
	private SmplType item1, item2;

	public Pair(SmplType i1, SmplType i2)
	{
		item1 = i1;
		item2 = i2;
	}

	public SmplType Item1()
	{
		return item1;
	}
	
	public SmplType Item2()
	{
		return item2;
	}

	public String toString()
	{
		return item1.toString() + ", " + item2.toString();
	}
}
