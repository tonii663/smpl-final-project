import java.util.ArrayList;

public class Statement extends Exp {

	protected Statement(String name, Exp... operands)
	{
		super(name, operands);
    }

    protected Statement(String name, ArrayList<Exp> operandList)
	{
		super(name, operandList);
    }

    public Statement(Exp e)
	{
		super("stmt", e);
    }

    public Exp getExp()
	{
		return getSubTree(0);
    }

    public Double visit(Visitor v)
	{
		return v.visitStatement(this);
    }
}
