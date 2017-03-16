
public class L105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	}
	
	public TreeNode helper(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
		if (s1>e1 || s2>e2) {
			return null;
		}
		
		int root = preorder[s1];
		TreeNode node = new TreeNode(root);
		int idx = 0;
		for (int i=s2; i<=e2; i++) {
			if (inorder[i] == root) {
				idx = i;
				break;
			}
		}
		
		int len = idx-s2;
		
		TreeNode left = helper(preorder, s1+1, s1+len, inorder, s2, idx-1);
		TreeNode right = helper(preorder, s1+1+len, e1, inorder, idx+1, e2);
		
		node.left = left;
		node.right = right;
		
		return node;
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