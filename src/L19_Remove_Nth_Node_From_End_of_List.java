public class L19_Remove_Nth_Node_From_End_of_List {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode first = dummy;
		ListNode last = dummy;
		
		while(n >0) {
			last = last.next;
			n--;
		}
		
		while(last.next != null) {
			first = first.next;
			last = last.next;
		}
		
		ListNode tmp = first.next;
		first.next = tmp.next;
		
		return dummy.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}