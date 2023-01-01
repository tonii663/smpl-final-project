public class SmplProgram extends ASTNode<StatementSequence>
{
	
    public SmplProgram(StatementSequence seq)
	{
		super("program", seq);
    }

    public StatementSequence getSeq()
	{
		return getSubTree(0);
    }

    public Double visit(Visitor v)
	{
		return v.visitSmplProgram(this);
    }

}
