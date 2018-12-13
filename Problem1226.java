import java.util.Scanner;
import java.util.Stack;

public class Problem1226 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			int[][] map = new int[16][16];
			int[][] visited = new int[16][16];
			Stack<Integer> rowStack = new Stack<Integer>();
			Stack<Integer> colStack = new Stack<Integer>();
			int startRow = 0;
			int startCol = 0;
			int endRow = 0;
			int endCol = 0;
			int answer = 0;
			
			int t = Integer.parseInt(scanner.nextLine());
			for(int j=0; j<16; j++) {
				String line = scanner.nextLine();
				for(int k=0; k<line.length(); k++) {
					map[j][k] = (int)(line.charAt(k) - '0');
					if(map[j][k] == 2) {
						startRow = j;
						startCol = k;
					}
					
					if(map[j][k] == 3) {
						endRow = j;
						endCol = k;
						map[j][k] = 0;
					}
				}
			}
			
			rowStack.push(startRow);
			colStack.push(startCol);
			visited[startRow][startCol] = 1;
			
			// logic.
			while(true) {
				int row;
				int col;
				
				if(!rowStack.isEmpty() && !colStack.isEmpty()) {
					row = rowStack.pop();
					col = colStack.pop();
				}
				else
					break;
				
				if(row == endRow && col == endCol) {
//					System.out.println("endRow" + endRow);
//					System.out.println("endCol" + endCol);
					answer = 1;
					break;
				}
				
				// 오
				if(map[row][col+1] == 0 && visited[row][col+1] == 0) {
					rowStack.push(row);
					rowStack.push(row);
					colStack.push(col);
					colStack.push(col+1);
					visited[row][col+1] = 1;
				}
				else if(map[row+1][col] == 0 && visited[row+1][col] == 0) {
					rowStack.push(row);
					rowStack.push(row+1);
					colStack.push(col);
					colStack.push(col);
					visited[row+1][col] = 1;
				}
				else if(map[row][col-1] == 0 && visited[row][col-1] == 0) {
					rowStack.push(row);
					rowStack.push(row);
					colStack.push(col);
					colStack.push(col-1);
					visited[row][col-1] = 1;
				}
				else if(map[row-1][col] == 0 && visited[row-1][col] == 0) {
					rowStack.push(row);
					rowStack.push(row-1);
					colStack.push(col);
					colStack.push(col);
					visited[row-1][col] = 1;
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}
}
