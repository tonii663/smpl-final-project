import java.util.ArrayList;

public class ExpVectorParamList extends Exp
{
	private ArrayList<Exp> values;
	
	public ExpVectorParamList(ArrayList<Exp> e)
	{
		super("vector-param-list", e);		
	}

	public ArrayList<Exp> getValues()
	{
		return values;
	}
	
	public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException
	{
		return v.visitExpVectorParamList(this, arg);
    }

}
