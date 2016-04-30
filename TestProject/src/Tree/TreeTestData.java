package Tree;


public class TreeTestData {

	public static Tree createNode(int nodeVal, int left, Tree right)
	{
		Tree t = new Tree();
		t.val = nodeVal;
		t.left = createNode(left, null, null);
		t.right = right;
		return t;
	}
	
	public static Tree createNode(int nodeVal, int left, int right)
	{
		Tree t = new Tree();
		t.val = nodeVal;
		t.left = createNode(left, null, null);
		t.right = createNode(right, null, null);
		return t;
	}
	public static Tree createNode(int nodeVal, Tree left, Tree right)
	{
		Tree t = new Tree();
		t.val = nodeVal;
		t.left = left;
		t.right = right;
		return t;
	}
	
	public static Tree getSampleTree1()
	{
		Tree right = createNode(3, 2, 4);
		Tree currentLeftTree = createNode(1, 0, right);
		right = createNode(8,7,null);
		Tree currentRightTree = createNode(6, null, right);
		Tree t = createNode(5, currentLeftTree, currentRightTree);
		return t;
	}
	
	public static Tree getSampleTree2()
	{
		return createNode(2, 3, 1);
	}
	
	
//    1
///   	\
//2     	3
/// \   	/ \
//2  -1 	0   8
///\   /\           /\   /\
//0  3 -5 4     6 -9 -6 1
	public static Tree getSampleTree3(){
		
		TreeFromPreIn ob = new TreeFromPreIn();
		
		int[] pre = {2,0,3};
		int[] in = {0,2,3};
		Tree t1 = ob.construct(pre, in);
//		TreeOperations.printTree(t1);
		
		pre = new int[] {-1,-5,4};
		in = new int[] {-5,-1,4};
		Tree t2 = ob.construct(pre, in);
//		TreeOperations.printTree(t2);
		
		Tree left = createNode(2, t1, t2);
//		TreeOperations.printTree(left);
		
		pre = new int[] {0,6,-9};
		in = new int[] {6,0,-9};
		t1 = ob.construct(pre, in);
		
		pre = new int[] {8,-6,1};
		in = new int[] {-6,8,1};
		t2 = ob.construct(pre, in);
		
		Tree right = createNode(3, t1, t2);
//		TreeOperations.printTree(right);
		
//		TreeOperations.printTree(createNode(1, left, right));
		return createNode(1, left, right);
	}
	
	
	public static void main(String[] args){
		getSampleTree3();
	}
}
