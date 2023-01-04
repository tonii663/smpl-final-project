import java.util.ArrayList;

public class ExpSeq extends Exp
{
	public ExpSeq(ArrayList<Exp> exps)
	{
		super("seq", exps);
	}
	
    public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException
	{
		return v.visitExpSeq(this, state);
    }

}
