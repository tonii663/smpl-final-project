// TODO(afb) :: Should we make this abstract and create a subclass
// for each type?

public class ExpLit extends Exp
{
    int val;
	
    public ExpLit(Integer v)
	{
		super(v.toString());
		val = v.intValue();
    }

    public int getVal()
	{
		return val;
    }

    public int visit(Visitor v)
	{
		return v.visitExpLit(this);
    }
}

