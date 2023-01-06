public class ProcClosure<T> 
{
    private ExpProc proc;
    private Environment<T> closingEnv;

    public ProcClosure(ExpProc fun, Environment<T> env)
	{
    
		proc = fun;
		closingEnv = env;
    }

    public ExpProc getProc()
	{
		return proc;
    }

    public Environment<T> getClosingEnv()
	{
		return closingEnv;
    }
}
