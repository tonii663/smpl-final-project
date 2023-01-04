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

    public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException
	{
		return v.visitStatementSequence(this, state);
    }

}

