package TODO;
import org.junit.Test;

public class L97_Interleaving_String {
    public boolean isInterleave(String s1, String s2, String s3) {
    	return false;
//    	if (s3.length() != s1.length() + s2.length()) {
//    		return false;
//    	}
//    	
//    	if (s1.isEmpty() || s2.isEmpty()) {
//    		return s3.equals(s2) || s3.equals(s1);
//    	}
//        int dp[][] = new int [s1.length()+1][s2.length()+1];
//        
//        // f[i][j] = f[i-p][j-q] && s1.subString(i-p, i) == s1.subString(j-q, j)
//        dp[0][0] = 1;
//        for (int i=1; i<=s1.length(); i++) {
//        	for (int j=1; j<=s2.length(); j++) {
//        		boolean meet = false;
//        		for (int p=1; p<=i; p++) {
//        			if (meet) {
//        				break;
//        			}
//        			for (int q=1; q<=j; q++) {
//        				if (dp[i-p][j-q] == 1) {
//	        				String tmp1 = s1.substring(i-p, i);
//	        				String tmp2 = s2.substring(j-q, j);
//	        				String tmp3 = s3.substring(i+j-p-q, i+j);
//	        				
//	        				if (tmp3.equals(tmp1+tmp2) || tmp3.equals(tmp2+tmp1)) {
//	        					dp[i][j] = 1;
//	        					meet = true;
//	        					break;
//	        				}
//        				}
//        			}
//        		}
//        	}
//        }
//        
//        if (dp[s1.length()][s2.length()] == 1) {
//        	return true;
//        } else {
//        	return false;
//        }
    	
    	
    }
    
    @Test
    public void test() {
    	isInterleave("a", "", "a");
    }
}