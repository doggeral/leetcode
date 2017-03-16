public class L80_Remove_Duplicates_from_Sorted_Array_II {
	// Follow up for "Remove Duplicates":
	// What if duplicates are allowed at most twice?
	// For example,
	// Given sorted array nums = [1,1,1,2,2,3],
	// Your function should return length = 5, with the first five elements of
	// nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the
	// new length.

	public int removeDuplicates(int[] nums) {
		boolean isdup = false;
		int cnt = 0;
		for (int i=0; i<nums.length; i++) {
			if (i == 0) {
				cnt++;
				continue;
			}
			
			if (nums[i] == nums[i-1]) {
				if(!isdup) {
					nums[cnt] = nums[i];
					cnt++;
					isdup = true;
				}
			} else {
				nums[cnt] = nums[i];
				cnt ++;
				isdup = false;
			}
		}
		
		
		return cnt;
	}
}