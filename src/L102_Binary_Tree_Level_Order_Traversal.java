import java.util.ArrayList;
import java.util.List;

public class L102_Binary_Tree_Level_Order_Traversal {
	List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
    	helper(root, 1);
        return ans;
    }
    
    public void helper(TreeNode node, int curlevel) {
    	if (node == null) {
    		return;
    	}
    	int size = ans.size();
    	if (curlevel > size) {
    		ans.add(new ArrayList<>());
    	}
    	ans.get(curlevel-1).add(node.val);
    	
    	helper(node.left, curlevel+1);
    	helper(node.right, curlevel+1);
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