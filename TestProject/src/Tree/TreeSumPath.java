package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TreeSumPath {

	Set<ArrayList<Integer>> sumPaths2;
	
	void doTraversal(Tree t, int remain, int oSum, ArrayList<Integer> temp){
		temp.add(t.val);
		if(remain == 0) sumPaths2.add(temp);
		traverse2(t.left, remain, temp, oSum);
		traverse2(t.right, remain, temp, oSum);
	}
	
	void traverse2(Tree t, int sum, ArrayList<Integer> curNodes, int oSum){
		if(t==null) return;
		ArrayList<Integer> temp = new ArrayList<Integer>(curNodes);
		doTraversal(t, sum - t.val, oSum, temp);
		
		temp = new ArrayList<Integer>();
		doTraversal(t, oSum-t.val, oSum, temp);
	}

	Set<ArrayList<Integer>> getSumPaths(Tree t, int sum){
		sumPaths2 = new HashSet<ArrayList<Integer>>();
		traverse2(t, sum, new ArrayList<Integer>(), sum);
		System.out.println(sumPaths2);
		return sumPaths2;
	}
	
	public static void main(String[] args) {
		Tree t = TreeTestData.getSampleTree3();
		TreeSumPath ob = new TreeSumPath();
		ob.getSumPaths(t, 5);
	}
}
