public class ExpCmp extends ExpBinaryOperator
{
	public ExpCmp(String cmp, Exp e1, Exp e2)
	{
		super(cmp, e1, e2);
	}

	public String getCmp()
	{
		return getName();
	}
	
	public <S, T> T visit(Visitor<S, T> v, S arg)
	{
		return v.visitExpCmp(this, arg);
    }

}
