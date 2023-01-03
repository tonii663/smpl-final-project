import java.util.*;


public class ExpFuncCall extends Exp
{

	public ExpFuncCall(String funName, ArrayList<Exp> args)
	{
		super(funName, args);
	}

	public <S, T> T visit(Visitor<S,T> v, S arg)
	{
		return v.visitExpFuncCall(this, arg);
    }	

}
