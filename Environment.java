import java.util.*;

public class Environment<T>
{
    Environment<T> parent;
	private HashMap<String, T> dictionary;
	private HashMap<String, Closure> functionDictionary;
	

	public Environment()
	{
		parent = null;
		dictionary = new HashMap<>();
		functionDictionary = new HashMap<String, Closure>();
	}

	public Environment(Environment<T> parent)
	{
		this.parent = parent;
		dictionary = new HashMap<>();
		functionDictionary = new HashMap<String, Closure>();
	}

    public static <T> Environment<T> makeGlobalEnv(Class<T> cls)
	{
		Environment<T> result =  new Environment<T>();		
		return result;
    }

	public Environment(Environment<T> parent, String[] ids, T[] values)
	{
		this.parent = parent;

		dictionary = new HashMap<>();
		for (int i = 0; i < ids.length; i++)
		{
			dictionary.put(ids[i], values[i]);
		}
		functionDictionary = new HashMap<>();
	}

	public Environment(Environment<T> parent, ArrayList<String> ids,
					   ArrayList<T> values)
	{
		this.parent = parent;
		dictionary = new HashMap<>();

		for (int i = 0; i < ids.size(); i++)
		{
			dictionary.put(ids.get(i), values.get(i));
		}

		functionDictionary = new HashMap<>();
	}

	public void put(String id, T value)
	{
		dictionary.put(id, value);
    }

	public T get(String id) throws UnboundVarException
	{
		T result = dictionary.get(id);
		if (result == null)
			if (parent == null)
				throw new UnboundVarException(id);
			else
				return parent.get(id);
		else
			return result;
    }

	public Closure getClosure(String id) throws UnboundVarException
	{
		Closure result = functionDictionary.get(id);
		if (result == null)
			if (parent == null)
				throw new UnboundVarException(id);
			else
				return parent.getClosure(id);
		else
			return result;
    }

	public void putClosure(String id, Closure value)
	{
		functionDictionary.put(id, value);
    }

	public String toString()
	{
		StringBuffer result = new StringBuffer();

		Iterator iter = dictionary.keySet().iterator();
		while (iter.hasNext())
		{
			result = result.append(iter.next().toString());
		}
		return result.toString();
    }

}
