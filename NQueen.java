//DAA Practical 4: N-Queen using Backtracking
package daa_practicals;

public class NQueen {
	
	final int N = 4;
	
	//for print the solution
	void printSolution(int board[][]) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(" " + board[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	//important function for check the location is safe or not
	boolean isSafe(int board[][], int row, int col) {
		int i,j;
		for(i=0; i<col; i++) {
			if(board[row][i] == 1)
				return false;
		}
		
		for(i=row, j=col; i>=0 && j>=0; i--, j--) {
			if(board[i][j] == 1)
				return false;
		}
		
		for(i=row, j=col; j>=0 && i<N; i++, j--) {
			if(board[i][j] == 1)
				return false;
		}
		return true;
	}
	
	
	boolean solveNQUtil(int board[][], int col) {
		if(col >= N) {
			return true;
		}
		
		for(int i=0; i<N; i++) {
			if(isSafe(board, i, col)) {
				board[i][col] = 1;
				
				if(solveNQUtil(board, col+1) == true)
					return true;
				
				board[i][col] = 0;
			}
		}
		return false;
	}
	
	
	//Initialize the board and check solution exist or not
	void solveNQ() {
		//creating array 4*4
		int board[][] = {{0,0,0,0},
						{0,0,0,0},
						{0,0,0,0},
						{0,0,0,0} };
		
		if(solveNQUtil(board,0) == false) {
			System.out.println("Solution does not exist");
		}
		else {
			printSolution(board);
		}
		
	}
	
	//main method calling the solveNQ
	public static void main(String[] args) {
		NQueen nq = new NQueen();
		
		nq.solveNQ();

	}

}
