public class L5_Longest_Palindromic_Substring {
	public String longestPalindrome(String s) {
		int dp[][] = new int [s.length()][s.length()];
		char array[] = s.toCharArray();
		int max = 0;
		int start = 0;
		int end = 0;
		
		for (int i = 0; i< s.length(); i++) {
			dp[i][i] = 1;
		}
		
		for (int i = 0; i < s.length(); i++){
			for (int j=0; j< i; j++) {
				if (i == j + 1) {
					if (array[i] == array[j]) {
						dp[j][i] = 1;
					}
				} else if (array[i] == array[j] && dp[j+1][i-1] == 1) {
					dp[j][i] = 1;
				}
				
				if (dp[j][i] == 1 && i - j + 1 > max) {
					max = i - j + 1;
					start = j;
					end = i;
				}
			}
		}
		
		return s.substring(start, end+1);
	}
}