import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1261 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int M = scanner.nextInt();
		int N = scanner.nextInt();
		int[][] map = new int[N][M];
		int[][] visited = new int[N][M];
		
		int[] dr = {0, -1, 0, 1};
		int[] dc = {-1, 0, 1, 0};
		
		scanner.nextLine();
		for(int i=0; i<N; i++)
			Arrays.fill(visited[i], -1);
		for(int i=0; i<N; i++) {
			String line = scanner.nextLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		Queue<Pair> q1 = new LinkedList<Pair>();
		Queue<Pair> q2 = new LinkedList<Pair>();
		q1.add(new Pair(0, 0));
		visited[0][0] = 0;
		
		while(!q1.isEmpty()) {
			Pair pair = q1.poll();
			int row = pair.row; 
			int col = pair.col;
			for(int i=0; i<4; i++) {
				int nextRow = row + dr[i];
				int nextCol = col + dc[i];
				if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M) {
					if(map[nextRow][nextCol] == 0 && visited[nextRow][nextCol] == -1) {
						q1.add(new Pair(nextRow, nextCol));
						visited[nextRow][nextCol] = visited[row][col];
					}
					
					if(map[nextRow][nextCol] == 1 && visited[nextRow][nextCol] == -1) {
						q2.add(new Pair(nextRow, nextCol));
						visited[nextRow][nextCol] = visited[row][col] + 1;
					}
				}
			}
			if(q1.isEmpty()) {
				q1 = q2;
				q2 = new LinkedList<Pair>();
			}
		}
		System.out.println(visited[N-1][M-1]);
	}
}
//class Pair{
//	int row;
//	int col;
//	
//	Pair(int row, int col){
//		this.row = row;
//		this.col = col;
//	}
//}
