import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return the zigzag level order traversal of its nodes' values. 
//(ie, from left to right, then right to left for the next level and alternate between).
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its zigzag level order traversal as:
//[
//  [3],
//  [20,9],
//  [15,7]
//]

public class L103_Binary_Tree_Zigzag_Level_Order_Traversal {
	List<List<Integer>> ans = new ArrayList<>();
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		helper(root, 1);
		List<List<Integer>> res = new ArrayList<>();
		for (int i=0; i<ans.size(); i++) {
			if(i%2==1) {
				List<Integer> tmp = new ArrayList<>();
				for (int j=ans.get(i).size()-1; j>=0; j--) {
					tmp.add(ans.get(i).get(j));
				}
				res.add(tmp);
			} else {
				res.add(ans.get(i));
			}
		}
        return res;
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