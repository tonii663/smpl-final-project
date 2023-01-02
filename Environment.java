import java.util.*;

public class Environment<T>
{
    Environment<T> parent;
	private HashMap<String, T> dictionary;


	public Environment()
	{
		parent = null;
		dictionary = new HashMap<>();
	}

    public static <T> Environment<T> makeGlobalEnv(Class<T> cls)
	{
		Environment<T> result =  new Environment<T>();
		return result;
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
}
