import java.io.Reader;
import java.io.StringReader;

public abstract class Walker
{
    private Visitor visitor;
	private SmplParser parser;

	
    public Walker(Visitor visitor)
	{
		this.visitor = visitor;
    }

    public Visitor getVisitor()
	{
		return visitor;
    }


	// NOTE(afb) :: Given a AST it walks it.
    public Double walk(ASTNode<? extends ASTNode> expr)
	{
		return expr.visit(visitor);
    }
	
    public Double run(Reader reader)
	{
		parser = new SmplParser(new Lexer(reader));
		SmplProgram program;

		try
		{
			program = (SmplProgram)parser.parse().value;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return -1.0;
		}
		
		Double result = walk(program);
		return result;
	}

}
