public class SmplInterpreter extends Walker<Environment<SmplType>, SmplType>
{
	public SmplInterpreter()
	{
		super(new Evaluator());
	}
}
