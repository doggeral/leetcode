import java.util.HashSet;

/**
 * Time window is a good approach, which is similar with the two pointer solution.
 * @author longfang
 *
 */
public class L3 {
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		char [] array = s.toCharArray();
		
		int max = 0;
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i< n; i++) {
			int cnt = 0;
			for (int j = i; j< n; j++) {
				int key = array[j];
				if (set.contains(key)) {
					break;
				} else {
					set.add(key);
					cnt ++;
				}
			}
			if (cnt > max) {
				max = cnt;
			}
			
			set.clear();
		}
		
		return max;
	}
}