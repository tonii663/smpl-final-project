import java.util.ArrayList;

import javax.sound.sampled.AudioFileFormat.Type;


public class SmplList extends SmplType<List>
{
	public SmplList(List value)
	{
		super(value);		
	}
		
	public String toString()
	{

		String result = "[ ";
		
		SmplPair p = getValue().getData();

		ArrayList<String> s = new ArrayList<String>();
		
		SmplType c = p;
		while(c instanceof SmplPair)
		{
			Pair x = (Pair)c.getValue();
			SmplType g = x.Item1();
			s.add(g.toString());
			c = x.Item2();
		}		

		for(int i = 0; i < s.size(); i++)
		{
			result += s.get(i);
			if((s.size()-1) > i)
			{
				result += ", ";
			}
		}

		result += " ]";
		return result;		
	}

	@Override
    public SmplList concat(SmplType o) throws TypeException {
		//TODO Modified
        if (o.getClass() == SmplList.class) {
            super.getValue().addAll(SmplList.class.cast(o).getValue());
            return this;
        }else {
            throw new TypeException(o.toString() + " is not a list");
        }
    }
}
