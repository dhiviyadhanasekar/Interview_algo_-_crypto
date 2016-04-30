package myPackage;

import java.util.HashMap;


public class AddTwoLists {

	public ListNode storeSum(int l1, int l2, ListNode result)
	{
		int sum = l1 + l2 + result.val;
		result.val = sum%10;
		if(sum > 9) result.next = new ListNode(sum/10); 
		else result.next = new ListNode(0);
		printNode(result);
		return result;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if(l1== null && l2== null) return null;
		if(l1== null) return l2;
		if(l2== null) return l1;

		ListNode sum = new ListNode(0);
		ListNode result = sum;
		ListNode prevRes;
		do {
			
			prevRes = storeSum(l1.val, l2.val, result);
			result = prevRes.next;
			l1 = l1.next;
			l2 = l2.next;
		}while(l1!=null && l2!=null);

		while(l1!=null)
		{
			prevRes = storeSum(l1.val, 0, result);
			result = prevRes.next;
			l1 = l1.next;
		}

		while(l2!=null)
		{
			prevRes = storeSum(l2.val, 0, result);
			result = prevRes.next;
			l2 = l2.next;
		}

		if(result.val == 0) prevRes.next = null;
		return sum;
	}
	
	static void printNode(ListNode l)
	{
		while(l!=null)
		{
			System.out.print(l.val);
			l = l.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.entrySet().removeIf(p->p.getKey()>'s');
		map.entrySet().removeIf(p->p.getValue()>1);
		ListNode l1 = new ListNode(2); 
		l1.next = new ListNode(4); 
		l1.next.next = new ListNode(3);
		AddTwoLists.printNode(l1);
		
		ListNode l2 = new ListNode(5); 
		l2.next = new ListNode(6); 
//		l2.next.next = new ListNode(4);
		AddTwoLists.printNode(l2);
		
		AddTwoLists ob = new AddTwoLists();
		ListNode res = ob.addTwoNumbers(l1, l2);
		AddTwoLists.printNode(res);
	}
}
