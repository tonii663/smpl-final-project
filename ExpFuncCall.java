import java.util.*;


public class ExpFuncCall extends Exp
{
	ArrayList<Exp> arguements;
	public ExpFuncCall(String funName, ArrayList<Exp> args)
	{
		super(funName, args);
		arguements = args;
	}

	public <S, T> T visit(Visitor<S,T> v, S arg)  throws VisitException
	{
		return v.visitExpFuncCall(this, arg);
    }	

	public ArrayList<Exp> getArgList()
	{
		return arguements;
	}

}
