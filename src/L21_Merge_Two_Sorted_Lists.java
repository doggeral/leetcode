public class L21_Merge_Two_Sorted_Lists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode list = dummy;
		while(l1 != null || l2 != null) {
			if (l1 == null) {
				list.next = new ListNode(l2.val);
				l2 = l2.next;
			} else if (l2 == null) {
				list.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				if (l1.val < l2.val) {
					list.next = new ListNode(l1.val);
					l1 = l1.next;
				} else {
					list.next = new ListNode(l2.val);
					l2 = l2.next;
				}
			}
			
			list = list.next;
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
}