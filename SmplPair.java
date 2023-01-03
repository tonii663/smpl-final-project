
public class SmplPair extends SmplType<Pair>
{

	public SmplPair(Pair value)
	{
		super(value);
	}
	
	public SmplType car() throws TypeException
	{
		return ((Pair)getValue()).Item1();
	}

	public SmplType cdr() throws TypeException
	{
		return ((Pair)getValue()).Item2();
	}

	public SmplType isPair()
	{
		return new SmplBoolean(true);
	}
	
	public String toString()
	{
		Pair p = ((Pair)getValue());
		String result = "(" + p.toString() + ")";
		return result;
	}
}
