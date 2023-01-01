// TODO(afb) :: Should we make this abstract and create a subclass
// for each type?

public abstract class ExpLit<T> extends Exp
{
    protected T value;
	
    public ExpLit(T v)
	{
		super(v.toString());
		this.value = v;
    }

	public T getLit()
	{
		return value;
	}
    
	public abstract Double getValue();
	
    public Double visit(Visitor v)
	{
		return v.visitExpLit(this);
    }
}

