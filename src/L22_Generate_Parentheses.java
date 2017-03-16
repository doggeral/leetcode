import java.util.ArrayList;
import java.util.List;

public class L22_Generate_Parentheses {
	public List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<String>();
		dfs(1, "", ans, 0, 0, n);
		
		return ans;
	}
	
	public void dfs(int step, String res, List<String> ans, int left, int right, int n) {
		if (step > 2*n) {
			ans.add(res);
			return;
		}
		
		if (left > right) {
			if (left < n) {
				dfs(step+1, res+"(", ans, left+1, right, n);
				dfs(step+1, res+")", ans, left, right+1, n);
			} else {
				dfs(step+1, res+")", ans, left, right+1, n);
			}
		} else if (left == right){
			dfs(step+1, res+"(", ans, left+1, right, n);
		}
	}
}