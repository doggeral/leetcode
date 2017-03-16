import java.util.ArrayList;
import java.util.List;

public class L94_Binary_Tree_Inorder_Traversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		inorder(root, res);
		
		return res;
    }
	
	private void inorder(TreeNode root, List<Integer> list) {
		if (root != null) {
			inorder(root.left, list);
			list.add(root.val);
			inorder(root.right, list);
		}
	}
}