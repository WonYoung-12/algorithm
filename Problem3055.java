import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem3055 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int R = scanner.nextInt();
		int C = scanner.nextInt();
		String[] input = new String[R];
		int[][] water = new int[R][C];
		int[][] d = new int[R][C];
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1,};
		scanner.nextLine();
		
		for(int row=0; row<R; row++) {
			input[row] = scanner.nextLine();
			for(int col=0; col<C; col++) {
				water[row][col] = -1;
				d[row][col] = -1;
			}
		}
		
		int startRow = 0, startCol = 0, endRow = 0, endCol = 0;
		Queue<P> queue = new LinkedList<P>();
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(input[i].charAt(j) == '*') {
					water[i][j] = 0;
					queue.add(new P(i, j));
				}
				else if(input[i].charAt(j) == 'S') {
					startRow = i;
					startCol = j;
				}
				else if(input[i].charAt(j) == 'D') {
					endRow = i;
					endCol = j;
				}
			}
		}
		// water bfs
		while(!queue.isEmpty()) {
			P p = queue.poll();
			int row = p.row;
			int col = p.col;
			for(int i=0; i<4; i++) {
				int nextRow = row + dr[i];
				int nextCol = col + dc[i];
				if(nextRow < 0 || nextRow > R-1 || nextCol < 0 || nextCol > C-1)
					continue;
				if(water[nextRow][nextCol] != -1)
					continue;
				if(input[nextRow].charAt(nextCol) == 'X' || input[nextRow].charAt(nextCol) == 'D')
					continue;
				water[nextRow][nextCol] = water[row][col] + 1;
				queue.add(new P(nextRow, nextCol));
			}
		}
		
		d[startRow][startCol] = 0;
		queue.add(new P(startRow, startCol));
		while(!queue.isEmpty()) {
			P p = queue.poll();
			int row = p.row;
			int col = p.col;
			for(int i=0; i<4; i++) {
				int nextRow = row + dr[i];
				int nextCol = col + dc[i];
				if(nextRow < 0 || nextRow > R-1 || nextCol < 0 || nextCol > C-1)
					continue;
				if(d[nextRow][nextCol] != -1)
					continue;
				if(input[nextRow].charAt(nextCol) == 'X')
					continue;
				if(water[nextRow][nextCol] <= d[row][col] + 1 && water[nextRow][nextCol] != -1)
					continue;
				d[nextRow][nextCol] = d[row][col] + 1;
				queue.add(new P(nextRow, nextCol));
			}
		}
		if(d[endRow][endCol] == -1)
			System.out.println("KAKTUS");
		else
			System.out.println(d[endRow][endCol]);
	}
}

class P{
	int row;
	int col;
	
	P(int row, int col){
		this.row = row;
		this.col = col;
	}
}
