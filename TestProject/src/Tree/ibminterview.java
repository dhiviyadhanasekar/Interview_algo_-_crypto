//var counter = function(){
//var count = 0;
//
//return function(){
//count++;
//}
//}
//
//counter();
//
//
//Tell me the difference between XHR/ajax and forms. When would you use them?
//
//
//Given a binary tree, not necessarily a BST return all paths with sum x:
//Ex for paths(5):
//
//        	     1
//    	/   	\
//           2     	3
//         / \   	/ \
//      2  -1 	0   8
//      /\   /\           /\   /\
//   0  3 -5 4     6 -9 -6 1

//[[1,2,2],[2,3],[1,2,2,0],[2,-1,4],[3,8,-6]]
//
//public class Tree{
//	int val;
//	Tree left;
//	Tree right;
//} 
//
//
//
//
//
//
//
//
//
//
//public class Solution{
//	
//	ArrayList<Tree> sumPaths;
//	ArrayList<ArrayList<Integer>> sumPaths2;
//
//	Integer traverse(Tree t, int sum){
//		if(t == null) return 0;
//		
//		Integer leftSum = traverse(t.left, sum);
//		Integer rightSum = traverse(t.right, sum);
//		
//if(leftSum == null || rightSum == null) return null;
//		
//Integer curSum = leftSum + rightSum + t.val;
//		
//if(curSum > sum) return null;
//		if(curSum == sum) { sumPaths.add(t); return;}
//		return curSum;
//}
//
//void doTraversal(Tree t, int sum, int oSum, ArrayList<int> curNodes){
//	Arraylist<int> temp = new ArrayList<int>(curNodes);
//	if(remain >=0) temp.add(t.val);
//	if(remain == 0) sumPaths2.add(temp);
//	traverse2(t.left, remain, temp, oSum);
//	traverse2(t.right, remain, temp, oSum);
//}
//void traverse2(Tree t, int sum, ArrayList<int> curNodes, int oSum){
//	if(t==null) return;
//	doTraversal(t, sum - t.val, oSum);
//	doTraversal(t, oSum-t.val, oSum);
//}
//
//	ArrayList<Tree> getSumPaths(Tree t, int sum){
//		sumPaths2 = new ArrayList<Tree>();
//		traverse2(t, sum);
//		return sumPaths;
//	}
//}
