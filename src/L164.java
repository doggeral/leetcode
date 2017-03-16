public class L164 {
	public int maximumGap(int[] nums) {
		if (nums.length < 2) {
			return 0;
		}
		int length = nums.length;
		int max = 0;
		
		for (int i=0; i<length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		
		int array[] = new int [max];
		for (int i = 0; i <length; i++) {
			array[nums[i]] = 1;
		}
		
		int res = 0;
		int b = 0;
		for (int i = 0; i< max; i++) {
			if (array[i] == 1) {
				if (b == 0) {
					b = i;
				} else {
					int gap = i - b;
					
					if (gap > res) {
						res = gap;
					}
				}
			}
		}
		return res;
	}
}