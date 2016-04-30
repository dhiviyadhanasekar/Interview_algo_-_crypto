package Tree;

import java.util.ArrayList;
import java.util.Random;

public class NodesAtRandom {
	
	int index = 0;
	ArrayList<Integer> getRandomNodes(Tree t, int n){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		index =0;
		preOrder(ret, t, n);
		return ret;
	}
	
	private void preOrder(ArrayList<Integer> ret, Tree t, int n) {
		if(t==null) return;
		index++;
		if(ret.size() < n) ret.add(t.val);
		else {
			Random r = new Random();
			int rVal = r.nextInt(index);
			if(rVal < n) ret.set(rVal, t.val);
		}
		preOrder(ret, t.left, n);
		preOrder(ret, t.right, n);
	}

	public static void main(String[] args){
		Tree t = TreeTestData.getSampleTree1();
		TreeOperations.printTree(t);
		NodesAtRandom ob = new NodesAtRandom();
		ArrayList<Integer> output = ob.getRandomNodes(t, 2);
		System.out.println(output);
	}
}
