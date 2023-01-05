import java.util.ArrayList;

public class ExpLet extends Exp {
    ArrayList<ExpBind> binding;
    StatementSequence body;
    public ExpLet(ArrayList<ExpBind> binds, StatementSequence bod ){
        super("bind",bod);
        binding=binds;
        body=bod;
    }

    public ArrayList<ExpBind> getBinds(){
        return binding;
    }
    public StatementSequence getBody(){
        return body;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
   
        return v.visitExpLet(this, arg);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
}