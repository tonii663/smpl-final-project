
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

	public SmplType isEqv(SmplType v)
	{
		Boolean result = this == v;
		return new SmplBoolean(result);
	}

	public SmplType isEqu(SmplType v)
	{
		if(v instanceof SmplPair)
		{
			SmplPair p1 = (SmplPair)v;

			SmplType r1 = p1.getValue().Item1().isEqu(getValue().Item1());
			SmplType r2 = p1.getValue().Item2().isEqu(getValue().Item2());
			
			Boolean result = Utils.isTrue(r1) && Utils.isTrue(r2);
			return new SmplBoolean(result);
		}
		
		return new SmplBoolean(false);
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
