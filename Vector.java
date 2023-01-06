import java.util.*;

class Vector
{
	private ArrayList<SmplType> values;
	
	public Vector(ArrayList<SmplType> l)
	{
		values = l;
	}
	
	public int length()
	{
		return values.size();
	}
	
	public ArrayList<SmplType> get()
	{
		return values;
	}

	public SmplType getAt(int index)
	{
		return values.get(index);
	}
}
