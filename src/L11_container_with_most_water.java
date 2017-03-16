public class L11_container_with_most_water {
	public int maxArea(int[] height) {
		int length = height.length;
		int i = 0;
		int j = length - 1;
		int res = 0;
		
		while(i < j) {
			int area = (j - i) * Math.min(height[i], height[j]);
				
			if (area > res) {
				res = area;
			}
			
			if (height[i] > height[j]) {
				j--;
			} else {
				i++;
			}
		}
		
		return res;
	}
}