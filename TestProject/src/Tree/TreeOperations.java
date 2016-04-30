package Tree;

import java.util.ArrayList;

public class TreeOperations {

	public static void printNodeRecursively(Tree t, int level, 
			ArrayList<ArrayList<Integer>> levelNodes)
	{
		if(levelNodes.size() == level)
		{
			levelNodes.add(new ArrayList<Integer>());
		}
		ArrayList<Integer> nodes = levelNodes.get(level);
		if(t == null)
		{
			nodes.add(null);
			return;
		}
//		System.out.println(t.val);
		nodes.add(t.val);
		printNodeRecursively(t.left, level+1, levelNodes);
		printNodeRecursively(t.right, level+1, levelNodes);
	}

	public static void printTree(Tree t)
	{
		final ArrayList<ArrayList<Integer>> levelNodes = new ArrayList<ArrayList<Integer>>();
		printNodeRecursively(t, 0, levelNodes);

		for(int level=0; level < levelNodes.size(); level++)
		{
			for(int nodeIndex = 0; nodeIndex < levelNodes.get(level).size(); nodeIndex++)
			{
				System.out.print(levelNodes.get(level).get(nodeIndex));
				System.out.print(" ");
			}
			System.out.println();
		}
	}


	public void preorderSearch(Tree t)
	{
		if(t == null) return;
		System.out.print(t.val + " ");
		preorderSearch(t.left);
		preorderSearch(t.right);
	}
	
	public void inorderSearch(Tree t)
	{
		if(t == null) return;
		inorderSearch(t.left);
		System.out.print(t.val + " ");
		inorderSearch(t.right);
	}
	
	public void postorderSearch(Tree t)
	{
		if(t==null) return;
		postorderSearch(t.left);
		postorderSearch(t.right);
		System.out.print(t.val + " " );
	}
	
//	public void post

	public static void main(String[] args) {

		Tree t = TreeTestData.getSampleTree1();
		TreeOperations  treeOps = new TreeOperations();
		TreeOperations.printTree(t);
		treeOps.preorderSearch(t);
		treeOps.inorderSearch(t);
		treeOps.postorderSearch(t);
	}

}
