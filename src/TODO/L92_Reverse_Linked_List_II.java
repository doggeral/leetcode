package TODO;
public class L92_Reverse_Linked_List_II {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode pre = dummy;
		ListNode cur = head;
		ListNode begin;
		ListNode end;
		
		
		m--;
		n--;
		
		while(m >0) {
			pre = cur;
			cur = cur.next;
			m--;
			n--;
		}
		
		System.out.println("pre:" + pre.val + " ;cur:" + cur.val);
		
		begin = cur;
		end = cur;
		
		while(n >0) {
			end = cur.next;
			end.next = cur;
			
			cur = cur.next;
			n--;
		}

		System.out.println("end:" + end.val + " ;cur:" + cur.val + " ;n:" + n);
		
		begin.next = cur;
		pre.next = end;
		
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