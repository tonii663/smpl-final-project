public class SmplInterpreter extends Walker<Environment<Object>, Object>
{
	public SmplInterpreter()
	{
		super(new Evaluator());
	}
}
