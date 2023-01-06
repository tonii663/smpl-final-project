import java.util.ArrayList;
import java.util.Arrays;

public abstract class ASTNode<E extends ASTNode>
{
	private String name;
    private ArrayList<E> subTrees;

	protected ASTNode(String name, E... subExps)
	{
		this.name = name;
		subTrees = new ArrayList<E>();

		for (E e : subExps) {
			subTrees.add(e);
		}
    }

	protected ASTNode(String name, ArrayList<E> subExps)
	{
		this.name = name;
		this.subTrees = subExps;
    }

	public ArrayList<E> getSubTrees()
	{
		return subTrees;
    }

    public E getSubTree(int index)
	{
		return subTrees.get(index);
    }

	public String getName()
	{
		return name;
    }

	public abstract <S, T> T visit(Visitor<S, T> v, S state)  throws VisitException;
}
