
public class SmplPair extends SmplType<Pair>
{

	public SmplPair(Pair value)
	{
		super(value);
	}

	public SmplPair(SmplType v1, SmplType v2)
	{
		super(new Pair(v1, v2));		
	}

	public Pair getPair()
	{
		return (Pair)getValue();
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
