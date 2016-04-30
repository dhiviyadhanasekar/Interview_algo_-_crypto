package Tree;

public class MorrisTraversal {
	//nlogn time complexity
	//but 1 space complexity => saves memory
	
//	public void morrisPostorder(Tree t)
//	{
//		while(t != null)
//		{
//			if(t.left == null)
//			{
//				t= t.right;
//			}
//			else
//			{
//				Tree pre = t.left;
//				while(pre.right != null && pre.right != t)
//					pre = pre.right;
//				
//				if(pre.right == null)
//				{
//					pre.right = t;
//					t = t.left;
//				}
//				else
//				{
//					System.out.print(t.val + " ");
//					t = pre.right;
//				}
//			}
//		}
//	}
	
	public void morrisPreorder(Tree t)
	{
		while(t!= null) 
		{
			if(t.left == null)
			{
				System.out.print(t.val + " ");
				t = t.right;
			}
			else
			{
				Tree pre =  t.left;
				while(pre.right != null && pre.right != t) 
					pre = pre.right;
				
				if(pre.right == null)
				{
					System.out.print(t.val + " ");
					pre.right = t;
					t = t.left;
				}
				else
				{
					pre.right  = null;
					t = t.right;
				}
			}
		}
	}
	
	public void morrisInorder(Tree t){
		while(t != null) 
		{
			if(t.left == null) 
			{
				System.out.print(t.val + " ");
				t = t.right;
			}
			else 
			{
				Tree temp = t.left;
				while(temp.right != null && temp.right != t)
				{
					temp = temp.right;
				}
				
				if(temp.right == null)
				{
					temp.right = t;
					t = t.left;
				}
				else 
				{
					temp.right = null;
					System.out.print(t.val + " ");
					t = t.right;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre = {10,5,1,2,7,50,100};
		BSTFromPre ob = new BSTFromPre();
		Tree t = ob.reContructTree(pre);
		TreeOperations.printTree(t);
		System.out.println("-------------------------");
		
		MorrisTraversal morris =  new MorrisTraversal();
//		morris.morrisInorder(t);
		morris.morrisPreorder(t);
		
	}
}
