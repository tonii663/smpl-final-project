
public abstract class ExpBinaryOperator extends Exp
{

    protected ExpBinaryOperator(String name, Exp exp1, Exp exp2)
	{
		super(name, exp1, exp2);
    }

    public Exp getLeftExp()
	{
		return (Exp)getSubTree(0);
    }

    public Exp getRightExp()
	{
		return (Exp)getSubTree(1);
    }

}
