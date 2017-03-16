import java.util.ArrayList;
import java.util.List;

public class L93_Restore_IP_Addresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		
		dfs(1, 0, s, "", res);
		
		return res;
	}
	
	public void dfs(int step, int idx, String s, String ans, List<String> res) {
		if (step > 4) {
			return;
		}
		for (int i=1; i<=3; i++) {
			if (idx + i <= s.length()) {
				String tmp = s.substring(idx, idx+i);
				
				if (!(tmp.startsWith("0") && i >1)) {
					Integer num = Integer.parseInt(tmp);
					
					if (num >=0 && num <= 255) {
						String oldAns = ans;
						ans= ans + tmp + ".";
						
						if (step == 4 && idx + i == s.length()) {
							res.add(ans.substring(0, ans.length() -1));
						} else {
							dfs(step + 1, idx + i, s, ans, res);
						}
						ans = oldAns;
					}
				}
			}
		}
	}
}