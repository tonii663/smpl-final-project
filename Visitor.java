
public interface Visitor
{
	public int visitExpAdd(ExpAdd exp);
    public int visitExpSub(ExpSub exp);
    public int visitExpMul(ExpMul exp);
    public int visitExpDiv(ExpDiv exp);
    
}
