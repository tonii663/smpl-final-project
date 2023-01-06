public class Closure<T>
{
    private StmtFuncDefinition function;
    private Environment<T> closingEnv;

    public Closure(StmtFuncDefinition fun, Environment<T> env)
	{
		function = fun;
		closingEnv = env;
    }

    public StmtFuncDefinition getFunction()
	{
		return function;
    }

    public Environment<T> getClosingEnv()
	{
		return closingEnv;
    }
}
