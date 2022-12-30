import java.util.ArrayList;


public abstract class Exp
{
	protected Exp(String name, Exp... subExps) {
		// super(name, subExps);
    }

    protected Exp(String name, ArrayList<Exp> subExps) {
		// super(name, subExps);
    }
}
