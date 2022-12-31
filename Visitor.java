
public interface Visitor
{
	public int visitSmplProgram(SmplProgram program);
	
	public int visitExpAdd(ExpAdd exp);
    public int visitExpSub(ExpSub exp);
    public int visitExpMul(ExpMul exp);
    public int visitExpDiv(ExpDiv exp);
    public int visitExpLit(ExpLit exp);
	
}
