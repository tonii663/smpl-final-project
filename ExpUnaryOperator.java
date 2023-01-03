public abstract class ExpUnaryOperator extends Exp
{
    protected ExpUnaryOperator(String name, Exp exp)
	{
		super(name, exp);
    }

    public Exp getExp()
	{
		return (Exp)getSubTree(0);
    }
}
