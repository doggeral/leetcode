
public class L173_Binary_Search_Tree_Iterator {
	// Implement an iterator over a binary search tree (BST). Your iterator will
	// be initialized with the root node of a BST.
	//
	// Calling next() will return the next smallest number in the BST.
	//
	// Note: next() and hasNext() should run in average O(1) time and uses O(h)
	// memory, where h is the height of the tree.
	//
	// Credits:
	// Special thanks to @ts for adding this problem and creating all test
	// cases.

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	ListNode dummy; 
	ListNode head;
	
	public L173_Binary_Search_Tree_Iterator(TreeNode root) {
		dummy = new ListNode(0);
		head = dummy;
		postOrder(root);
	}
	
	public void postOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		postOrder(root.right);
		ListNode node = new ListNode(root.val);
		head.next = node;
		head = head.next;
		postOrder(root.left);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (dummy.next != null) {
			dummy = dummy.next;
			return true;
		}
		
		return false;
	}

	/** @return the next smallest number */
	public int next() {
		int res = dummy.val;
		
		return res;
	}

	/**
	 * Your BSTIterator will be called like this: BSTIterator i = new
	 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
	 */
	
	
	public static void main(String args[]) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		
		t2.left = t1;
		t2.right = t4;
		t4.left = t3;
		t4.right = t5;
		
		L173_Binary_Search_Tree_Iterator itr = new L173_Binary_Search_Tree_Iterator(t2);
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}