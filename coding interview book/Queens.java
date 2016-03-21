
public class Queens {
	int board[][];
	int columnsForRow[];
	
	public Queens() {
		board = new int[8][8];
		columnsForRow = new int[8];
	}
	
	public static void main(String[] args) {
		
		Queens q = new Queens();
		
		q.placeQueen(0);
	}
	
	public boolean check(int row) {
		for(int i=0; i<row; i++) {
			int diff = Math.abs(columnsForRow[row] - columnsForRow[i]);
			
			if(diff==0 || diff == row -i) 
				return false;
		}
		return true;
	}
	
	public void placeQueen(int row) {
		
		if(row == 7) {
			printBoard();
			System.out.println();
			System.out.println();
		} else {
			
			for(int i=0; i<8; i++) {
				columnsForRow[row] = i;
				if(check(row))
					placeQueen(row+1);
			}
		}
	}
	
	public void printBoard() {
		for(int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				if(j==columnsForRow[i]) {
					System.out.print(columnsForRow[i] + " ");
				} else {
					System.out.print(-1 + " ");
				}
			}
			
			System.out.println();
		}
	}
}
