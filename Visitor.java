/* NOTE(afb)
 * <S> The type of the information needed by the visitor
 * <T> The type of result returned by the visitor 
 */
public interface Visitor<S, T>
{
	public S getDefaultState();
		
	public T visitSmplProgram(SmplProgram program, S state) throws VisitException;
	
	public T visitStmtFuncDefinition(StmtFuncDefinition s, S State) throws VisitException;	
		
	public T visitStatement(Statement stmt, S state) throws VisitException;
	public T visitStatementSequence(StatementSequence seq, S state) throws VisitException;
	public T visitStatementDefinition(StatementDefinition def, S state) throws VisitException;
	
	public T visitExpFuncCall(ExpFuncCall exp, S state) throws VisitException;
		
	public T visitExpAdd(ExpAdd exp, S state) throws VisitException;
	public T visitExpSub(ExpSub exp, S state) throws VisitException;
	public T visitExpMul(ExpMul exp, S state) throws VisitException;
	public T visitExpDiv(ExpDiv exp, S state) throws VisitException;
	public T visitExpMod(ExpMod exp, S state) throws VisitException;
	public T visitExpCmp(ExpCmp exp, S state) throws VisitException;
	
	public T visitExpBitAnd(ExpBitAnd exp, S state) throws VisitException;
	public T visitExpBitOr(ExpBitOr exp, S state) throws VisitException;
	public T visitExpBitNot(ExpBitNot exp, S state) throws VisitException;
	
	public T visitExpAnd(ExpAnd exp, S state) throws VisitException;
	public T visitExpOr(ExpOr exp, S state) throws VisitException;
	public T visitExpNot(ExpNot exp, S state) throws VisitException;
	
	public T visitExpSeq(ExpSeq exp, S state) throws VisitException;
	public T visitExpAssign(ExpAssign exp, S state) throws VisitException;	
		
	public T visitExpVar(ExpVar exp, S state) throws VisitException;
	public T visitExpLit(ExpLit exp, S state) throws VisitException;
	public T visitExpOps(ExpOps exp, S state) throws VisitException;
	public T visitExpPrint(ExpPrint exp, S state) throws VisitException;
	public T visitExpPrintln(ExpPrintln exp, S state) throws VisitException;
	public T visitExpRead(ExpRead exp, S state) throws VisitException;
	public T visitExpReadInt(ExpReadInt exp, S state) throws VisitException;
	
	public T visitExpVectorParam(ExpVectorParam exp, S state) throws VisitException;
	public T visitExpVectorParamList(ExpVectorParamList exp, S state) throws VisitException;

    public T visitExpBind(ExpBind expBind, S arg) throws VisitException;

    public T visitExpLet(ExpLet expLet, S arg) throws VisitException;
	
	// public T visitExpPair(ExpPair exp, S state);
	// public T visitExpList(ExpList exp, S state);
}
