package Tree;

import java.util.ArrayList;

public class SubtreeSum {

	private ArrayList<Tree> sumPaths;

	private Integer traverse(Tree t, int sum){
		if(t == null) return 0;

		Integer leftSum = traverse(t.left, sum);
		Integer rightSum = traverse(t.right, sum);
//		if(leftSum == null || rightSum == null) return null;
		Integer curSum = leftSum + rightSum + t.val;

//		if(curSum > sum) return null;
		if(curSum == sum) { sumPaths.add(t);}
		return curSum;
	}
	
	public void printSubTreeWithSum(Tree t, int sum){
		sumPaths = new ArrayList<Tree>();
		traverse(t, sum);
		
		for(int i = 0; i < sumPaths.size(); i++){
			TreeOperations.printTree(sumPaths.get(i));
			System.out.println("--------------------");
		}
	}
	
	public static void main(String[] args) {
		SubtreeSum ob = new SubtreeSum();
		Tree t = TreeTestData.getSampleTree3();
		ob.printSubTreeWithSum(t, 5);
	}
}
