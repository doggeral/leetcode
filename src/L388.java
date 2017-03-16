
public class L388 {
	public static int lengthLongestPath(String input) {
		int [] array = new int[1000];
		int res = 0;
		
		String[] strList = input.split("\n");
		
		for (String str : strList) {
			if (str.contains("\t")) {
				// find the size of \t
				String[] tmp = str.split("\t");
				
				int cnt = tmp.length - 1;
				array[cnt] = tmp[cnt].length();
				
				if (str.contains(".")) {
					int length = sum(cnt, array) + cnt;
					
					if (length > res) {
						res = length;
					}
				}
			} else {
				array[0] = str.length();
				if (str.contains(".")) {
					if (array[0] > res) {
						res = array[0];
					}
				}
			}
		}
		
		return res;
	}
	
	public static int sum(int idx, int [] array) {
		int sum = 0;
		for (int i=0; i<=idx;i++) {
			sum += array[i];
		}
		
		return sum;
	}
	
	public static void main(String args[]) {
		System.out.println(lengthLongestPath("dir"));
	}
	
}