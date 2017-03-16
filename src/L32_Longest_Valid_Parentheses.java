import java.util.Stack;

public class L32_Longest_Valid_Parentheses{
    public int longestValidParentheses(String s) {
    	char [] array = s.toCharArray();
    	
    	Stack<String> stack1 = new Stack();
    	Stack<Integer> stack2 = new Stack();
    	
    	for (int i=0; i<array.length; i++) {
    		String str = String.valueOf(array[i]);
    		if (stack1.isEmpty()) {
    			stack1.push(str);
    			stack2.push(i);
    		}
    		
    		String top = stack1.peek();
    		
    		if (top.equals("(") && str.equals(")")) {
    			stack1.pop();
    			stack2.pop();
    		} else {
    			stack1.push(str);
    			stack2.push(i);
    		}
    	}
    	
    	if (stack2.isEmpty()) {
    		return s.length();
    	}
    	
    	int last = s.length();
    	int max = 0;
    	while(stack2.isEmpty()) {
    		int i = stack2.pop();
    		
    		int gap = last-i;
    		
    		last = i;
    		
    		if (gap>max) {
    			max = gap;
    		}
    	}
    	
    	if (last > max) {
    		max = last;
    	}
    	
    	return max;
    	
    }
}