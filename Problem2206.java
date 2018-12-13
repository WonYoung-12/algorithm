import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2206 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		scanner.nextLine();
		int[][] map = new int[N][M];
		int[][][] d = new int[N][M][2];
		int[] dr = {0, -1, 0, 1};
		int[] dc = {-1, 0, 1, 0};
		
		for(int i=0; i<N; i++) {
			String line = scanner.nextLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		Queue<Pair> queue = new LinkedList<Pair>();
		d[0][0][0] = 1;
		queue.add(new Pair(0, 0, 0));
	
		while(!queue.isEmpty()) {
			Pair now = queue.poll();
			int row = now.row;
			int col = now.col;
			int count = now.count;
			for(int i=0; i<4; i++) {
				int nextRow = row + dr[i];
				int nextCol = col + dc[i];
				if(nextRow < 0 || nextCol < 0 || nextRow > N-1 || nextCol > M -1) 
					continue;
				if(map[nextRow][nextCol] == 0 && d[nextRow][nextCol][count] == 0) {
					d[nextRow][nextCol][count] = d[row][col][count] + 1;
					queue.add(new Pair(nextRow, nextCol, count));
				}
				if(count == 0 && map[nextRow][nextCol] == 1 && d[nextRow][nextCol][count+1] == 0) {
					d[nextRow][nextCol][count + 1] = d[row][col][count] + 1;
					queue.add(new Pair(nextRow, nextCol, count+1));
				}
			}
		}
		if(d[N-1][M-1][0] != 0 && d[N-1][M-1][1] != 0)
			System.out.println(Math.min(d[N-1][M-1][0], d[N-1][M-1][1]));
		else if(d[N-1][M-1][0] != 0)
			System.out.println(d[N-1][M-1][0]);
		else if(d[N-1][M-1][1] != 0)
			System.out.println(d[N-1][M-1][1]);
		else
			System.out.println(-1);
	}
}
class Pair{
	int row;
	int col;
	int count;
	
	Pair(int row, int col, int count){
		this.row = row;
		this.col = col;
		this.count = count;
	}
}
