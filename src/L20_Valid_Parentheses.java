import java.util.Stack;

public class L20_Valid_Parentheses {
	// ()[]{}
	public boolean isValid(String s) {
		char array[] = s.toCharArray();
		
		Stack<Character> stack = new Stack<>();
		for (int i=0; i<array.length; i++) {
			if (stack.isEmpty()) {
				stack.push(array[i]);
				continue;
			}
			char peek = stack.peek();
			
			if (peek == '(' && array[i] == ')' || peek == '[' && array[i] == ']' || peek == '{' && array[i] == '}') {
				stack.pop();
			} else {
				stack.push(array[i]);
			}
		}
		
		return stack.isEmpty();
	}
}