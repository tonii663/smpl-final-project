public class SmplCharacter extends SmplType<Character>
{
	public SmplCharacter(Character value)
	{
		super(value);
	}

	public SmplType isEqv(SmplType v)
	{
		if(v instanceof SmplCharacter)
		{			
			SmplCharacter i = (SmplCharacter)v;
			
			char r1 = (Character)getValue();
			char r2 = (Character)i.getValue();		   			
			return new SmplBoolean(r1 == r2);
		}

		throw new TypeException();
	}

	public SmplType isEqu(SmplType v)
	{
		return areEqual(v);
	}

	public SmplType areEqual(SmplType v)
	{
		if(v instanceof SmplCharacter)
		{			
			SmplCharacter i = (SmplCharacter)v;
			
			char r1 = (Character)getValue();
			char r2 = (Character)i.getValue();		   			
			return new SmplBoolean(r1 == r2);
		}

		throw new TypeException();
	}

	public SmplType notEqual(SmplType v)
	{
		return new SmplBoolean(!Utils.isTrue(areEqual(v)));
	}

}
