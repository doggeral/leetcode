public class L2_Add_Two_Numbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ans = null;
		ListNode header = null;
		boolean isTen = false;
		while(l1 != null || l2 != null) {
			int a1, a2;
			if (l1 != null) {
				a1 = l1.val;
				l1 = l1.next;
			} else {
				a1 = 0;
			}
			
			if (l2 != null) {
				a2 = l2.val;
				l2 = l2.next;
			} else {
				a2 = 0;
			}
			
			int res = a1 + a2;
			if (isTen) {
				res ++;
			}
			if (res >= 10) {
				isTen = true;
				res = res - 10;
			} else {
				isTen = false;
			}
			
			if (ans == null) {
				ans = new ListNode(res);
				header = ans;
			} else {
				ans.next = new ListNode(res);
				ans = ans.next;
			}
		}
		
		if (isTen) {
			ans.next = new ListNode(1);
		}
		
		return header;
	}
	
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
}