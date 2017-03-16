//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//Given an encoded message containing digits, determine the total number of ways to decode it.
//
//For example,
//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//The number of ways decoding "12" is 2.
public class L91_Decode_Ways {
	public int numDecodings(String s) {
		if (s.length() == 0) {
			return 0;
		}
		// f[i] = f[i-1] + f[i-1]
		int ans[] = new int[s.length()+1];
		char input[] = s.toCharArray();
		ans[0] = 1;
		if (input[0] != '0') {
			ans[1] = 1;
		} else {
			ans[1] = 0;
		}
		
		for (int i=2; i<=input.length; i++) {
			int idx = i-1;
			if (input[idx] == '0') {
				ans[i] = ans[i-2];
				continue;
			}
			
			if (input[idx-1] == '1' || input[idx-1] == '2' && input[idx] <= '6') {
				ans[i] = ans[i-1] + ans[i-2];
				continue;
			}
			
			ans[i] = ans[i-1];
		}
		
		return ans[s.length()];
	}
}