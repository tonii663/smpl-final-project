
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

	public SmplType isEqu(SmplType v)
	{
		if(v instanceof SmplVector)
		{			
			if(Utils.isTrue(size().notEqual(v.size())))
			{
				return new SmplBoolean(false);
			}

			int s = (Integer)size().getValue();
			for(int i = 0; i < s; i++)
			{
				SmplInteger ind = new SmplInteger(i);
				SmplType t = index(ind).isEqv(v.index(ind));

				if(!Utils.isTrue(t))
				{
					return new SmplBoolean(false);
				}
			}

			return new SmplBoolean(true);
		}
		
		return new SmplBoolean(false);

	}

	public SmplType isEqv(SmplType v)
	{
		if(v instanceof SmplVector)
		{
			if(v != this)
			{
				return new SmplBoolean(false);
			}
			
			if(Utils.isTrue(size().notEqual(v.size())))
			{
				return new SmplBoolean(false);
			}

			int s = (Integer)size().getValue();
			for(int i = 0; i < s; i++)
			{
				SmplInteger ind = new SmplInteger(i);
				SmplType t = index(ind).isEqv(v.index(ind));

				if(!Utils.isTrue(t))
				{
					return new SmplBoolean(false);
				}
			}

			return new SmplBoolean(true);
		}
		
		return new SmplBoolean(false);
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


