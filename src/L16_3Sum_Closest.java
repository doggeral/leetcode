import java.util.Arrays;

public class L16_3Sum_Closest {
	public int threeSumClosest(int[] nums, int target) {
		if (nums.length == 3) {
			return nums[0] + nums[1] + nums[2];
		}
		
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int res = 0;
		
		for (int i=0; i<nums.length-2; i++) {
			int des = target - nums[i];
			
			int s = i+1;
			int e = nums.length - 1;
			
			while(s<e) {
				int sum = nums[s] + nums[e];
				
				if (Math.abs(nums[i] + sum - target)< min) {
					min = Math.abs(nums[i] + sum - target);
					res = nums[i] + sum;
				}
				if (sum > des) {
					e--;
				} else {
					s++;
				}
			}
		}
		
		return res;
	}
}