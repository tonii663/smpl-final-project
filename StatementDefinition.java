import java.util.*;

public class StatementDefinition extends Statement
{
	private String id;
	
	public StatementDefinition(String id, Exp exp)
	{
		super("def", exp);
		this.id = id;		
	}

    public String getId()
	{
		return id;
    }

    public Exp getExp()
	{
		return getSubTree(0);
    }

    public <S, T> T visit(Visitor<S, T> v, S state)  throws VisitException
	{
		return v.visitStatementDefinition(this, state);
    }
}

