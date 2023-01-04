/* NOTE(afb)
 * <S> The type of the information needed by the visitor
 * <T> The type of result returned by the visitor 
 */
public interface Visitor<S, T>
{
	public S getDefaultState();
	
	public T visitSmplProgram(SmplProgram program, S state);

	public T visitStmtFuncDefinition(StmtFuncDefinition s, S State);	
	
	public T visitStatement(Statement stmt, S state);
	public T visitStatementSequence(StatementSequence seq, S state);
	public T visitStatementDefinition(StatementDefinition def, S state);

	public T visitExpFuncCall(ExpFuncCall exp, S state);
	
	public T visitExpAdd(ExpAdd exp, S state);
    public T visitExpSub(ExpSub exp, S state);
    public T visitExpMul(ExpMul exp, S state);
    public T visitExpDiv(ExpDiv exp, S state);
	public T visitExpMod(ExpMod exp, S state);
	public T visitExpCmp(ExpCmp exp, S state);

	public T visitExpBitAnd(ExpBitAnd exp, S state);
	public T visitExpBitOr(ExpBitOr exp, S state);
	public T visitExpBitNot(ExpBitNot exp, S state);

	public T visitExpAnd(ExpAnd exp, S state);
	public T visitExpOr(ExpOr exp, S state);
	public T visitExpNot(ExpNot exp, S state);
	
	public T visitExpVar(ExpVar exp, S state);
	public T visitExpLit(ExpLit exp, S state);
	public T visitExpOps(ExpOps exp, S state);
	public T visitExpPrint(ExpPrint exp, S state);
	public T visitExpPrintln(ExpPrintln exp, S state);

	public T visitExpVectorParam(ExpVectorParam exp, S state);
	public T visitExpVectorParamList(ExpVectorParamList exp, S state);
	
	// public T visitExpPair(ExpPair exp, S state);
	// public T visitExpList(ExpList exp, S state);
}
