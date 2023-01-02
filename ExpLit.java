// TODO(afb) :: Should we make this abstract and create a subclass
// for each type?

public class ExpLit<T> extends Exp
{
    protected Object value;
	protected String type;

	
    public ExpLit(Object v, String type)
	{
		super(v.toString());
		this.value = v;
		this.type = type;
	}

	
	public Object getValue()
	{
		return value;
	}    

	public String getType()
	{
		return type;
	}    

    public <S, T> T visit(Visitor<S, T> v, S state)
	{
		return v.visitExpLit(this, state);
    }
}

