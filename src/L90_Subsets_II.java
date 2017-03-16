import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class L90_Subsets_II {
	// Given a collection of integers that might contain duplicates, nums,
	// return all possible subsets.
	//
	// Note: The solution set must not contain duplicate subsets.
	//
	// For example,
	// If nums = [1,2,2], a solution is:
	//	[
	//	  [2],
	//	  [1],
	//	  [1,2,2],
	//	  [2,2],
	//	  [1,2],
	//	  []
	//	]
	
	Set<List<Integer>> set = new HashSet<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		dfs(0, nums, new ArrayList<Integer>());
		List<List<Integer>> res = new ArrayList<>();
		
		set.forEach(item -> {res.add(item);});

		res.add(new ArrayList<Integer>());
		return res;
	}
	
	public void dfs(int num, int nums[], List<Integer> res) {
		for (int i=num; i<nums.length; i++) {
			List<Integer> tmp = copyRes(res);
			tmp.add(nums[i]);
			
			if (!set.contains(tmp)) {
				set.add(tmp);
			}
			
			dfs(i+1, nums, tmp);
		}
	}
	
	public List<Integer> copyRes(List<Integer> input) {
		List<Integer> res = new ArrayList<Integer>();
		for (Integer item : input) {
			res.add(item);
		}
		
		return res;
	}
	
	@Test
	public void test() {
		int []nums = {1,2,2};
		subsetsWithDup(nums);
	}
}