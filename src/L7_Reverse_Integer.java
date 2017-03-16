public class L7_Reverse_Integer {
	public int reverse(int x) {
		boolean negative = x > 0 ? false : true;

		if (negative) {
			x *= -1;
		}

		String s = String.valueOf(x);
		long ans = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			ans = 10 * ans + (s.charAt(i) - '0');
		}
		
		if (negative) {
			ans*=-1;
		}
		
		if (ans>Integer.MAX_VALUE || ans<Integer.MIN_VALUE) {
			return 0;
		} else {
			return (int) ans;
		}
	}
}