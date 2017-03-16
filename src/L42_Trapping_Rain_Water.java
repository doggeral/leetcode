public class L42_Trapping_Rain_Water {
	public int trap(int[] height) {
		if (height.length < 3) {
			return 0;
		}
		
		int l[] = new int [height.length];
		int r[] = new int [height.length];
		
		l[0] = -1;
		r[height.length - 1] = -1; 
		for (int i = 1; i< height.length; i++) {
			l[i] = Math.max(l[i-1], height[i-1]);
		}
		
		for (int i =  height.length -2; i>=0; i--) {
			r[i] = Math.max(r[i+1], height[i+1]);
		}
		
		int sum = 0;
		for (int i = 0; i< height.length; i++) {
			int s =  Math.min(l[i], r[i]) - height[i];
			
			if (s > 0) {
				sum +=s;
			}
		}
		
		return sum;
	}
}