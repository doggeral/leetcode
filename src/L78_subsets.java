import java.util.ArrayList;
import java.util.List;

public class L78_subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		dfs(0, nums, new ArrayList<Integer>(), ans);
		ans.add(new ArrayList<Integer>());
		return ans;
	}
	
	public void dfs(int index, int [] nums, List<Integer> res, List<List<Integer>> ans) {
		for (int i = index; i< nums.length; i++){
			res.add(nums[i]);
			ans.add(copyRes(res));
			if (i == nums.length - 1) {
				return;
			}
			dfs(index+1, nums, copyRes(res), ans);
			
			int size = res.size();
			res.remove(size - 1);
		}
	}
	
	public List<Integer> copyRes(List<Integer> input) {
		List<Integer> res = new ArrayList<Integer>();
		for (Integer item : input) {
			res.add(item);
		}
		
		return res;
	}
}