/* NOTE(afb)
 * <S> The type of the information needed by the visitor
 * <T> The type of result returned by the visitor 
 */
public interface Visitor<S, T>
{
	public S getDefaultState();
	
	public T visitSmplProgram(SmplProgram program, S state);
	
	public T visitStatement(Statement stmt, S state);
	public T visitStatementSequence(StatementSequence seq, S state);
	public T visitStatementDefinition(StatementDefinition def, S state);
	
	public T visitExpAdd(ExpAdd exp, S state);
    public T visitExpSub(ExpSub exp, S state);
    public T visitExpMul(ExpMul exp, S state);
    public T visitExpDiv(ExpDiv exp, S state);
	public T visitExpMod(ExpMod exp, S state);

	public T visitExpVar(ExpVar exp, S state);
	public T visitExpLit(ExpLit exp, S state);
	
}
