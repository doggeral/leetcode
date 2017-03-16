import java.util.ArrayList;
import java.util.List;

public class L95_Unique_Binary_Search_Trees_II {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<TreeNode> generateTrees(int n) {

		return generateTrees(1, n);
	}

	public List<TreeNode> generateTrees(int s, int e) {
		List<TreeNode> unique = new ArrayList<TreeNode>();
		if (s > e) {
			unique.add(null);
			return unique;
		}
		for (int i = s; i <= e; i++) {
			for (TreeNode left : generateTrees(s, i - 1)) {
				for (TreeNode right : generateTrees(i + 1, e)) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					unique.add(root);
				}
			}
		}
		return unique;
	}

}