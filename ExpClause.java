public class ExpClause extends Statement
{
    ExpCmp predicate;
    Exp consequent;

    public ExpClause(ExpCmp exp1, Exp exp2)
    {
        super("clause", exp1, exp2);
        this.predicate = exp1;
        this.consequent = exp2;
    }


    public ExpClause(Exp exp2)
    {
        super("clause", exp2);
        this.predicate = null;
        this.consequent = exp2;
    }

    public ExpCmp getPredicate()
    {
        return predicate;
    }

    public Exp getConsequent()
    {
        return consequent;
    }

    public Boolean isElse(){
        return predicate == null;
    }

    public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException
    {
        return v.visitExpClause(this, state);
    }
}