import java.util.*;

public class ExpCase extends Exp
{
	ArrayList<ExpClause> caseList;
	
	public ExpCase(ArrayList<ExpClause> cl)
	{
        super("ExpCase");
		this.caseList = cl;	
	}

    public ArrayList<ExpClause> getCaseList()
	{
		return this.caseList;
    }


    public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException
	{
		return v.visitExpCase(this, state);
    }
}