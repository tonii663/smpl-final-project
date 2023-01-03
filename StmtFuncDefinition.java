import java.util.*;

public class StmtFuncDefinition extends Statement {
    // Implement this class

	private ArrayList<String> paramList;
	private StatementSequence body;
	
    public StmtFuncDefinition(String functionName, ArrayList<String> pList, StatementSequence body)
	{
		super(functionName);
		paramList = pList;
		this.body = body;
    }

	public ArrayList<String> getParams()
	{
		return paramList;
	}

	public int getParamsCount()
	{
		return paramList.size();
	}

	public StatementSequence getBody()
	{
		return body;
	}

	public <S, T> T visit(Visitor<S,T> v, S arg)
	{
		return v.visitStmtFuncDefinition(this, arg);
    }	
}
