import java.util.ArrayList;
import java.util.List;

public class L98_Validate_Binary_Search_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<Integer> list = new ArrayList<Integer>();

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		inOrderTraversal(root);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) <= list.get(i - 1))
				return false;
		}
		return true;
	}

	public void inOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		inOrderTraversal(root.left);
		list.add(root.val);
		inOrderTraversal(root.right);
	}
}