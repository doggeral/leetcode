import org.junit.Test;

public class L24_Swap_Nodes_in_Pairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode pre = dummy;
		while(head != null && head.next != null) {
			ListNode tmp = head.next;
			head.next = tmp.next;
			tmp.next = head;
			pre.next = tmp;
			pre = pre.next.next;
			head = pre.next;
		}
		
		return dummy.next;
	}
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	@Test
	public void test() {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		l1.next = l2;
		
		swapPairs(l1);
	}
}