
import java.util.*;
import java.io.*;

public class Main {
public static char[][] board;
public static int rows, cols, queries;	
public static char[] actions;
public static int[] robotPos;
public static int count;
	
	public static final char NORMAL_CELL = '.';
	public static final char STICKER_CELL = '*';
	public static final char PILLAR_CELL = '#';
	public static final char DIR_NORTH = 'N';
	public static final char DIR_SOUTH = 'S';
	public static final char DIR_EAST = 'L';
	public static final char DIR_WEST = 'O';
	public static final char TURN_RIGHT = 'D';
	public static final char TURN_LEFT = 'E';
	public static final char MOVE = 'F';

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		rows = Integer.parseInt(st.nextToken());
		cols = Integer.parseInt(st.nextToken());
		queries = Integer.parseInt(st.nextToken());
		robotPos = new int[2];

		while(rows!=0 || cols!=0 || queries !=0) {
			build(br);
			count = 0;
			
			actions = br.readLine().toCharArray();
			for(int i=0; i<actions.length; i++) {
				modifyBoard(actions[i]);
			}

			pw.println(count);
			st = new StringTokenizer(br.readLine());
            rows = Integer.parseInt(st.nextToken());
            cols = Integer.parseInt(st.nextToken());
            queries = Integer.parseInt(st.nextToken());
		}
		
		pw.close();
	}

	




public static void modifyBoard(char c) {
		int i = robotPos[0], j = robotPos[1];

		if (c == MOVE) {
			switch (board[i][j]) {
				case DIR_NORTH:
					if (i-1 >= 0 && board[i-1][j] != PILLAR_CELL) {
						if(board[i-1][j] == STICKER_CELL) {
							count++;
						}
						board[i-1][j] = board[i][j];
						board[i][j] = NORMAL_CELL;
						i -=1;
					}
					break;
				case DIR_EAST:
					if(j+1<cols && board[i][j+1] != PILLAR_CELL) {
						if(board[i][j+1] == STICKER_CELL) {
							count++;
						}
						board[i][j+1] = board[i][j];
						board[i][j] = NORMAL_CELL;
						j+=1;
					}
					break;
				case DIR_SOUTH:
					if(i+1 < rows && board[i+1][j] != PILLAR_CELL) {
						if(board[i+1][j] == STICKER_CELL) {
							count++;
						}
						board[i+1][j] = board[i][j];
						board[i][j] = NORMAL_CELL;
						i+=1;
					}
					break;
				case DIR_WEST:
					if(j-1 >=0 && board[i][j-1] != PILLAR_CELL) {
						if(board[i][j-1] == STICKER_CELL) {
							count++;
						}
						board[i][j-1] = board[i][j];
						board[i][j] = NORMAL_CELL;
						j-=1;
					}
					break;
			}
                }     
			
                else if (c == TURN_RIGHT) {
                        switch(board[i][j]) {
                                case DIR_NORTH:
                                        board[i][j] = DIR_EAST;
                                        break;
                                case DIR_EAST:
                                        board[i][j] = DIR_SOUTH;
                                        break;
                                case DIR_SOUTH:
                                        board[i][j] = DIR_WEST;
                                        break;
                                case DIR_WEST:
                                        board[i][j] = DIR_NORTH;
                                        break;
                        }
                }

                else if (c == TURN_LEFT) {
                        switch(board[i][j]) {
                                case DIR_NORTH:
                                        board[i][j] = DIR_WEST;
                                        break;
                                case DIR_EAST:
                                        board[i][j] = DIR_NORTH;
                                        break;
                                case DIR_SOUTH:
                                        board[i][j] = DIR_EAST;
                                        break;
                                case DIR_WEST:
                                        board[i][j] = DIR_SOUTH;
                                        break;
                        }
                }
		

		robotPos[0] = i;
		robotPos[1] = j;
	}

	public static void build(BufferedReader br) throws IOException {
		board = new char[rows][cols];
		
        for(int i=0; i<rows; i++) {
            board[i] = br.readLine().toCharArray();
            for(int j=0; j<cols; j++) {
                    if(board[i][j] !=NORMAL_CELL && board[i][j]!=PILLAR_CELL && board[i][j]!=STICKER_CELL) {
                            robotPos[0] = i;
                            robotPos[1] = j;
                    }
            }
        }

	}
}
