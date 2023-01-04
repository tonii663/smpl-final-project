public class SmplCharacter extends SmplType<Character>
{
	public SmplCharacter(Character value)
	{
		super(value);
	}


	public SmplType isEqu(SmplType v)
	{
		if(v instanceof SmplCharacter)
		{			
			SmplCharacter i = (SmplCharacter)v;

			Character r1 = (Character)i.getValue();
			Character r2 = (Character)getValue();
			
			return new SmplBoolean(r1 == r2);
		}
		
		return new SmplBoolean(false);
	}

}
