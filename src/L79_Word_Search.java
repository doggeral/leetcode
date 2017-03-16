public class L79_Word_Search {
	public boolean exist(char[][] board, String word) {
		int m = board[0].length;
		int n = board.length;
		int [][] state = new int [n][m];
		for (int j=0; j<m; j++) {
			for (int i=0; i<n; i++) {
				if (board[i][j] == word.charAt(0)) {
					if (dfs(board, state, 0, word, i, j)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean dfs(char[][] board, int [][] state, int idx, String word, int y, int x) {
		int m = board[0].length;
		int n = board.length;
		if (x < 0 || x >= m || y < 0 || y >= n || state[y][x] == 1) {
			return false;
		}
		
		if (board[y][x] == word.charAt(idx)) {
			if (idx == word.length() - 1) {
				return true;
			}
			
			state[y][x] = 1;
			
			if (dfs(board, state, idx+1, word, x+1, y) || 
					dfs(board, state, idx+1, word, x-1, y) ||
					dfs(board, state, idx+1, word, x, y+1) ||
					dfs(board, state, idx+1, word, x, y-1)) {
				return true;
			}
		}
		
		state[y][x] = 0;
		
		return false;
	}
}