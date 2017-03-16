package TODO;
public class L19_Remove_Nth_Node_From_End_of_List {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first = head;
		ListNode last = head;
		for (int i=0; i<n; i++) {
			if (last != null) {
				last = last.next;
			} else {
				return head.next;
			}
		}
		
		while(last.next != null) {
			first = first.next;
			last = last.next;
		}
		
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}