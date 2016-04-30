package Tree;

import java.util.Arrays;

public class TreeFromPreIn {

//	class Tree {
//		int node;
//		Tree left;
//		Tree right;
//	}
	
	int preIndex = 0;
	Tree construct(int[] pre, int[] in)	{
		preIndex = 0;
		return actualConstruct(pre, in);
	}

	private Tree actualConstruct(int[] pre, int[] in) {
		if(preIndex >= pre.length  || in.length==0) return null;

		Tree t= new Tree();
		t.val = pre[preIndex++]; //first element in preorder is the root
		
		//Get pos of root in the inorder. 
		//Elements left of that will be the left tree
		//Elements to the right of that will be the right tree
		int i =0;
		for(;i< in.length; i++){
			if(in[i] == t.val) break;
		}
//		System.out.println(t.val + ": " + i + ": " + Arrays.toString(in));
		int[] leftIn = Arrays.copyOfRange(in, 0, i);
		int[] rightIn = Arrays.copyOfRange(in, i+1, in.length);

		t.left = actualConstruct(pre, leftIn);
		t.right = actualConstruct(pre, rightIn);
		return t;
	}

	public static void main(String[] args) {

		int[] pre = {10,5,80,9,2,6};
		int[] in = {80,5,9,10,6,2};
		TreeFromPreIn ob = new TreeFromPreIn();
		Tree t = ob.construct(pre, in);
		TreeOperations.printTree(t);
	}

}
