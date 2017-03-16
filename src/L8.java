public class L8 {
	public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        
        str = str.trim();
        
        boolean nagitave = false;
        int idx = 0;
        if (str.startsWith("-")) {
        	nagitave = true;
        	idx++;
        }
        
        if (str.startsWith("+")) {
        	idx++;
        }
        
        double res=0;
        
        for (int i = idx; i< str.length(); i++) {
        	char c = str.charAt(i);
        	
        	if (c < '0' || c > '9') {
        		break;
        	}
        	
        	int tmp = c - '0';
        	res = res*10 + tmp;
        }
        
        if (nagitave) {
        	res = res * -1;
        }
        
        if (res > Integer.MAX_VALUE) {
        	return Integer.MAX_VALUE;
        }
        
        if (res < Integer.MIN_VALUE) {
        	return Integer.MIN_VALUE;
        }
        
        return (int) res;
	}
}