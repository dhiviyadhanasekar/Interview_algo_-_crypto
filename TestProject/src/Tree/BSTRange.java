package Tree;

public class BSTRange {
	
	private int max = 0;
	private boolean valid(int val, int a, int b){
		if(val > a && val < b) return true;
		return false;
	}

	private Integer postOrder(Tree t, int a, int b){
		if(t== null) return 0;

		Integer leftCnt = postOrder(t.left, a, b);
		Integer rightCnt = postOrder(t.right, a, b);

		if(leftCnt == null || rightCnt == null) return null;
		if(!valid(t.val, a, b)) return null;

		int cnt =1 + leftCnt + rightCnt;
		if(max < cnt) max = cnt;
		return cnt;	
	}

	public int getMaxNodesInRange(Tree t, int a, int b){
		max =0;
		postOrder(t, a, b);
		return max;
	}

	public static void main(String[] args) {

		int[] preOrderData = {10,5,1,2,7,50,100};
		BSTFromPre ob = new BSTFromPre();
		Tree t = ob.reContructTree(preOrderData);
		TreeOperations.printTree(t);

		BSTRange ob1 = new BSTRange();
		System.out.println(ob1.getMaxNodesInRange(t, 0, 101));
	}
}
