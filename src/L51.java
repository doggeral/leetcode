import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class L51 {
    public List<List<String>> solveNQueens(int n) {
    	int res[][] = new int[n][n];
    	List<List<String>> list = new ArrayList<>();
    	dfs(n, 0, res, list);
    	//printList(list);
    	
        return list;
    }
    
    public void dfs(int n, int step, int[][] res, List<List<String>> list) {
    	if (step == n) {
    		list.add(getList(res));
    		return;
    	}
    	for (int x=0; x<n; x++) {
    		res[step][x] = 1;
    		if (isValid(res, step, x, n)) {
    			dfs(n, step+1, res, list);
    		}
    		res[step][x] = 0;
    	}
    }
    
    public boolean isValid(int[][] res, int step, int x, int n) {
    	for (int i = 0; i <n; i++) {
    		if (i != x && res[step][i] ==1) {
    			return false;
    		}
    	}
    	
    	for (int i = 0; i <n; i++) {
    		if (i != step && res[i][x] ==1) {
    			return false;
    		}
    	}
    	
    	for (int i=1; i<n; i++) {
    		if (step - i >= 0 && x - i >=0) {
    			if (res[step - i][x - i] == 1) {
    				return false;
    			}
    		}
    		
    		if (step + i < n && x + i < n) {
    			if (res[step + i][x + i] == 1) {
    				return false;
    			}
    		}
    		
    		if (step -i >= 0 && x + i < n) {
    			if (res[step - i][x + i] == 1) {
    				return false;
    			}
    		}
    		
    		if (step + i < n && x - i >= 0) {
    			if (res[step + i][x - i] == 1) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
    
    public List<String> getList(int [][] res) {
    	List<String> list = new ArrayList<>();
    	for (int i = 0; i< res.length; i++) {
    		String s = "";
    		for (int j = 0; j< res.length; j++) {
        		if (res[i][j] == 0) {
        			s+= ".";
        		} else {
        			s+= "Q";
        		}
        	}
    		
    		list.add(s);
    	}
    	
    	return list;
    }
    
    public void printList(List<List<String>> res) {
    	for (int i=0; i<res.size(); i++) {
    		if (i == 0) {
    			System.out.println("[");
    		}
    		
    		System.out.print(" ");
    		
    		List<String> sub = res.get(i);
    		for (int j = 0; j< sub.size(); j++) {
    			if (j != 0) {
    				System.out.print(" ");
    			}
    			System.out.print(sub.get(j));
    			
    			
    			if (j != sub.size()-1) {
    				System.out.println();
    			} else if (i != res.size() - 1){
    				System.out.println(",");
    			}
    		}
    	}
    	System.out.println();
    	System.out.println("]");
    }
    
    @Test
    public void test() {
    	solveNQueens(4);
    }
}