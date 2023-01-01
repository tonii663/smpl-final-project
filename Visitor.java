
public interface Visitor
{
	public Double visitSmplProgram(SmplProgram program);
	
	public Double visitStatement(Statement stmt);
	public Double visitStatementSequence(StatementSequence seq);

	public Double visitExpAdd(ExpAdd exp);
    public Double visitExpSub(ExpSub exp);
    public Double visitExpMul(ExpMul exp);
    public Double visitExpDiv(ExpDiv exp);
	public Double visitExpMod(ExpMod exp);
	
	public Double visitExpLit(ExpLit exp);
}
