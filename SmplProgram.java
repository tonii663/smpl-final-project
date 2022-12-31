public class SmplProgram extends ASTNode<Exp>
{
	
    public SmplProgram(Exp e)
	{
		super("program", e);
    }

    public Exp getSeq()
	{
		return getSubTree(0);
    }

    public int visit(Visitor v)
	{
		return v.visitSmplProgram(this);
    }

}
