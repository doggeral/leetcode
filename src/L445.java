import java.math.BigInteger;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class L445 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String n1 = getNumber(l1);
		String n2 = getNumber(l2);
		
		BigInteger b1 = new BigInteger(n1);
		BigInteger b2 = new BigInteger(n2);
		
		BigInteger sum = b1.add(b2);
		
		String sumString = sum.toString();
		
		ListNode node = null;
		ListNode header = null;
		
		for (int i = 0; i< sumString.length(); i++) {
			if (node == null) {
				node = new ListNode(sumString.charAt(i) - '0');
				header = node;
			} else {
				ListNode newNode = new ListNode(sumString.charAt(i) - '0');
				node.next = newNode;
				node = newNode;
			}
		}
		
		return header;
		
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {val = x;}
	}
	
	public String getNumber(ListNode l1) {
		String res = "";
		while(l1 != null) {
			res = res + l1.val;
			l1 = l1.next;
		}
		
		if (res.equals("")) {
			return "0";
		}
		return res;
	}
}