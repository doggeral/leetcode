public class L9_Palindrome_Number {
	public boolean isPalindrome(int x) {
		String s = ((Integer) x).toString();
		char array[] = s.toCharArray();
		int st = 0; 
		int end = s.length() - 1;
		boolean isSuccess = true;
		
		while(st<=end) {
			if (array[st] != array[end]) {
				isSuccess = false;
				break;
			}
			st++;
			end--;
		}
		
		return isSuccess;
	}
}