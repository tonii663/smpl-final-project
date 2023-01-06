public class SmplString extends SmplType<String>
{
	public SmplString(String value)
	{
		super(value);
	}

	public SmplType add(SmplType v)
	{
		String result = toString() + v.toString();
		return new SmplString(result);
	}

	public SmplType substr(SmplType st, SmplType en) 
	{
		if((st instanceof SmplInteger) && (en instanceof SmplInteger))
		{
			String s = (String)getValue();

			int start = (Integer)st.getValue();
			int end = (Integer)en.getValue();

			if(s.length() < start || s.length() > end)
			{
				throw new TypeException();
			}
			else if(start >= end)
			{
				return new  SmplString("");
			}

			return new SmplString(s.substring(start, end));
		}

		throw new TypeException();
	}

}
