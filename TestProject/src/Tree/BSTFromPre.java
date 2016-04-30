package Tree;

public class BSTFromPre extends Tree{

	
	int index = 0;
	Tree construct(int[] pre, int min, int max)
	{
		if(index>=pre.length) return null;
		if(pre[index]>max || pre[index] < min) return null;
		Tree t = new Tree();
		t.val = pre[index++];
		t.left = construct(pre,min, t.val);
		t.right = construct(pre, t.val, max);
		return t;
	}
	
	Tree reContructTree(int[] preorder)
	{
		index = 0;
		return construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static void main(String[] args) {
		
		int[] pre = {10,5,1,2,7,50,100};
		BSTFromPre ob = new BSTFromPre();
		Tree t = ob.reContructTree(pre);
		TreeOperations.printTree(t);
	}

}
