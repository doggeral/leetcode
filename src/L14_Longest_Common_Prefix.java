public class L14_Longest_Common_Prefix {
	public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 ) {
            return "";
        }
		int max = strs[0].length();
		String ans = "";
		boolean exit = false;
		
		for (int i=1; i<=max; i++) {
			String subString = strs[0].substring(0, i);
			
			for (int j=0; j<strs.length; j++) {
				if (strs[j].startsWith(subString)) {
					continue;
				} else {
					exit = true;
					break;
				}
			}
			
			if (!exit) {
				ans = subString;
			} else {
				break;
			}
		}
		
		return ans;
	}
}