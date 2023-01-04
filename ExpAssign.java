import java.util.*;

public class ExpAssign extends Statement
{
	private String id;
	
	public ExpAssign(String id, Exp exp)
	{
		super(":=", exp);
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

    public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException
	{
		return v.visitExpAssign(this, state);
    }
}

