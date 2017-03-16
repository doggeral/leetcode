public class L33_Search_in_Rotated_Sorted_Array {
	public int search(int[] nums, int target) {
		int s = 0; 
		int e = nums.length;
		
		while(s<=e) {
			int mid = (s+e)/2;
			if (nums[mid] == target) {
				return mid;
			} else {
				if (nums[mid] > target) {
					if (nums[s] > target) {
						s = mid+1;
					} else {
						e = mid-1;
					}
				} else {
					if (nums[e] > target) {
						s = mid+1;
					} else {
						e = mid-1;
					}
				}
			}
		}
		
		return -1;
	}
}