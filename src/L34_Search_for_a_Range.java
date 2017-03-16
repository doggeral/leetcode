import java.util.Arrays;

public class L34_Search_for_a_Range {
	public int[] searchRange(int[] nums, int target) {
		int idx = Arrays.binarySearch(nums, target);
		
		if (idx < 0) {
			return new int[] {-1, -1};
		} else {
			int s = idx;
			int e = idx;
			for (int i = idx - 1; i>=0; i--) {
				if (nums[i] == target) {
					s--;
				}
			}
			
			for (int i = idx + 1; i<nums.length; i++) {
				if (nums[i] == target) {
					e++;
				}
			}
			
			return new int[] {s, e};
		}
		
	}
}