public class SmplInterpreter extends Walker
{
	public SmplInterpreter()
	{
		super(new Evaluator());
	}
}
