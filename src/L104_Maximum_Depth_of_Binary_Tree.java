public class L104_Maximum_Depth_of_Binary_Tree {
	public int maxDepth(TreeNode root) {
		return helper(root);
	}
	
	public int helper(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + Math.max(helper(node.left), helper(node.right));
		}
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