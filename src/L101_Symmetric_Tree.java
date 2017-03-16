public class L101_Symmetric_Tree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left != null && root.right != null) {
			return helper(root.left, root.right);
		}
		
		if (root.left == null && root.right == null) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean helper(TreeNode node1, TreeNode node2) {
		if (node1 == null || node2 == null) {
			return node1 == node2;
		}
		
		return node1.val == node2.val && helper(node1.left, node2.right) && helper(node1.right, node2.left);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}