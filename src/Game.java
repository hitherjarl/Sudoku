import java.util.*;
public class Game {
	static int[][] createBoard(int[][] board){
		//instantialize a random method
		int k=1,n=1;
		//loops to populate the board
		for(int i = 0; i<board.length;i++) {
			 k=n;
			for(int j = 0; j<board.length;j++) {
				          if(k<=9){
				        	  if((int)(Math.random() * (2 - 1 + 1) + 1) == 1) {
				        		  board[i][j] = 0;
				        	  }else {
				              board[i][j]=k;}
				              k++;
				          }else{
				           k=1;
				           if((int)(Math.random() * (2 - 1 + 1) + 1) == 1) {
				        		  board[i][j] = 0;
				        	  }else {
				              board[i][j]=k;}
				           k++;
				          }
				      }
				      n=k+3;
				      if(k==10)
				      n=4;
				      if(n>9)
				      n=(n%9)+1;
			
		}
		return board;
	}
	
	static void validate(int[][] board, int xCoordinate, int yCoordinate, int value){
		int count = 0;
		if(board[xCoordinate][yCoordinate] != 0) {
			System.out.println("INVALID, try again");
			return;
			}
		else {
				while(count < board.length) {
					if(value == board[xCoordinate][count] || value == board[count][yCoordinate]){
						System.out.println("Exists in the horizontal or vertical  cells");
						return;
					}
					count++;
				}
				int row = xCoordinate/3;
				int col = yCoordinate/3;
				for(int x = (row*3); x<(row*3)+3;x++) {
					for(int y = (col*3); y<(col*3)+3;y++) {
						if(board[x][y] != 0) {
							if(board[x][y] == value) {
								System.out.println("Exists in the 3x3 grid");
								return;
							}
						}				
					}
				}
				board[xCoordinate][yCoordinate] = value;	
			}
		return;
		//return board; 
	}
	static boolean solved(int[][] board) {
		for(int i = 0; i<board.length;i++) {
			for(int j = 0; j<board.length;j++) {
				if(board[i][j]>0) {continue;}
				else {return false;}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		//create the sudoku board;
		
		boolean game = false;
		int[][] board = new int[9][9];
		board = createBoard(board);
		Scanner in = new Scanner(System.in);
		
		while(solved(board) == false) {
			System.out.println("-------------------");
			for(int i = 0; i<board.length;i++) {
				System.out.print("|");
				for(int j = 0; j<board.length;j++) {
					if(board[i][j] == 0){
						System.out.print("."+"|");
					}
					else{
						System.out.print(board[i][j]+"|");
					}
					
				}
				System.out.println("");
				System.out.println("-------------------");
			}
			System.out.println("input the x coordinate");
			int xCoor = in.nextInt();
			System.out.println(xCoor);
			System.out.println("input the y coordinate");
			int yCoor = in.nextInt();
			System.out.println(yCoor);
			System.out.println("input the value between 1 - 9");
			int val = in.nextInt();
			System.out.println(val);
			validate(board, xCoor, yCoor, val);	
		}	
		System.out.println("Sudoku Solved!");
		return;
		
	}

}
