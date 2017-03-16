import java.util.HashMap;

public class L1Two_Sum {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i< nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for (int i = 0; i< nums.length; i++) {
			int other = target - nums[i];
			
			if (map.containsKey(other) && map.get(other) != i) {
				int res[] = {i, map.get(other)};
				return res;
			}
		}
		
		return null;
	}
}