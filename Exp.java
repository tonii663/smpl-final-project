import java.util.ArrayList;
import java.util.Arrays;

public abstract class Exp extends ASTNode<Exp>
{	
	protected Exp(String name, Exp... subExps)
	{
		super(name, subExps);
    }

    protected Exp(String name, ArrayList<Exp> subExps)
	{
		super(name, subExps);
    }
}
