public class L6_ZigZag_Conversion {
	public String convert(String s, int numRows) {
		if (numRows == 0) {
			return s;
		}
		String [] ans = new String[numRows];
		
		for (int i=0; i<numRows; i++) {
			ans[i] = "";
		}
		String res ="";
		char[] array = s.toCharArray();
		
		int idx = 0;
		while(idx < s.length()) {
			for (int i=0;i<numRows;i++) {
				if (idx < s.length()) {
					ans[i] += array[idx];
					idx++;
				} else {
					break;
				}
			}
			
			for (int i = numRows - 2; i > 0; i--) {
				if (idx < s.length()) {
					ans[i] += array[idx];
					idx++;
				} else {
					break;
				}
			}
		}
		
		for (int i=0; i<numRows; i++) {
			res+=ans[i];
		}
		
		return res;
	}
}