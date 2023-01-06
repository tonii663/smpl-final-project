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

    public <S, T>  T visit(Visitor<S, T> v, S state) throws VisitException
	{
		return v.visitSmplProgram(this, state);
    }

}
