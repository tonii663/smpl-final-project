import java.util.ArrayList;

public class List
{
	private SmplPair list;

	public List(ArrayList<SmplType> data)
	{
		list = makeList(data, 0);
	}
	
	public SmplPair getData()
	{
		return list;
	}
	
	private SmplPair makeList(ArrayList<SmplType> data, int index)
	{
		if(data.size() == 0)
		{
			return new SmplPair(new SmplNil(), new SmplNil());
		}
		else if(index >= (data.size()-1))
		{
			return new SmplPair(data.get(index), new SmplNil());
		}
		else
		{
			return new SmplPair(data.get(index), makeList(data, index+1));
		}
	}
}

