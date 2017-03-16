import java.util.ArrayList;
import java.util.List;

public class L17_Letter_Combinations_of_a_Phone_Number {
	public List<String> letterCombinations(String digits) {
		char[][] map = {{'0'},
						{'0'},
						{'3', 'a', 'b', 'c'},
						{'3', 'd', 'e', 'f'},
						{'3', 'g', 'h', 'i'},
						{'3', 'j', 'k', 'l'},
						{'3', 'm', 'n', 'o'},
						{'4', 'p', 'q', 'r', 's'},
						{'3', 't', 'u', 'v'},
						{'4', 'w', 'x', 'y', 'z'}
						};
		
		char [] input = digits.toCharArray();
		
		List<String> ans = new ArrayList<String>();
		dfs(0, map, input, "", ans);
		
		return ans;
	}
	
	public void dfs(int step, char[][] map, char[] input, String res, List<String> ans) {
		if (step == input.length) {
			if (!res.isEmpty()) {
				ans.add(res);
			}
			return;
		}
		int idx = input[step] - '0';
		if (idx == 0 || idx == 1) {
			dfs(step+1, map, input, res, ans);
		} else {
			char[] candidate = map[idx];
	
			int loopSize = candidate[0] - '0';
	
			for (int j = 1; j <= loopSize; j++) {
				dfs(step+1, map, input, res+candidate[j], ans);
			}
		}
	}
}