import java.util.ArrayList;
import java.util.List;

public class L77_Combinations {
	// Given two integers n and k, return all possible combinations of k numbers
	// out of 1 ... n.
	//
	// For example,
	// If n = 4 and k = 2, a solution is:

	// [
	// [2,4],
	// [3,4],
	// [2,3],
	// [1,2],
	// [1,3],
	// [1,4],
	// ]

	List<List<Integer>> res = new ArrayList<>();
	
	public List<List<Integer>> combine(int n, int k) {
		dfs(1, 1, n, k, new ArrayList<Integer>());
		
		return res;
	}
	
	public void dfs(int num, int step, int n, int k, List<Integer> ans) {
		for (int i=num; i<=n; i++) {
			ans.add(i);
			
			if (step == k) {
				List<Integer> tmp = new ArrayList<>();
				for (int j=0; j<k; j++) {
					tmp.add(ans.get(j));
				}
				res.add(tmp);
			} else {
				dfs(i+1, step+1, n, k, ans);
			}
			
			int size = ans.size();
			ans.remove(size-1);
		}
	}
}