import java.util.*;

public class StatementSequence extends Statement {

    public StatementSequence()
	{
		super("sequence");
    }

    public StatementSequence(Statement s)
	{
		super("sequence", s);
    }

    public ArrayList<Exp> getSeq()
	{
		return getSubTrees();
    }

    public StatementSequence add(Statement s)
	{
		getSubTrees().add(s);
		return this;
    }

    public Double visit(Visitor v)
	{
		return v.visitStatementSequence(this);
    }

}

