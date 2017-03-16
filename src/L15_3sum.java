import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class L15_3sum {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();
		HashSet<ArrayList<Integer>> hs = new HashSet<>();
		for (int i = 0; i < nums.length-2; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			
			while(j <k) {
				int sum = nums[i] + nums[j] + nums[k];
				
				if (sum < 0) {
					j++;
				} else if(sum > 0) {
					k--;
				} else {
					ArrayList<Integer> res = new ArrayList<>();
					res.add(nums[i]);
					res.add(nums[j]);
					res.add(nums[k]);
					
					if (!hs.contains(res)) {
						ans.add(res);
						hs.add(res);
					}
					
					j++;
					k--;
				}
			}
		}
		
		return ans;
	}
}