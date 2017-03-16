public class L26_Remove_Duplicates_from_Sorted_Array {
	public int removeDuplicates(int[] nums) {
		int idx = 0;
		int cnt = 0;
		for (int i = 0; i<nums.length; i++) {
			if (i != 0) {
				if (nums[i] == nums[i-1]) {
					cnt ++;
				} else {
					nums[idx] = nums[i];
					idx ++;
				}
			} else {
				idx ++;
			}
		}
		
		return nums.length - cnt;
	}
}