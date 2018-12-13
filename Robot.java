import java.util.Scanner;

public class Robot {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int[][] map  = new int[N][M];
		int[][] visited = new int[N][M];
		int r = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		int answer = 1;
		int[] dr = {0, -1, 0, 1};
		int[] dc = {-1, 0, 1, 0};
		int turn = 0;
		
		for(int row=0; row<N; row++) 
			for(int col=0; col<M; col++) 
				map[row][col] = scanner.nextInt();
			
		visited[r][c] = 1;
		while(true) {
			if(map[r+dr[d]][c+dc[d]] == 0 && visited[r+dr[d]][c+dc[d]] == 0) {
				turn = 0;
				r += dr[d];
				c += dc[d];
				
				if(d>0)
					d--;
				else
					d=3;
				
				answer++;
				visited[r][c]=1;
			}
			else { 
				// 후진.
				if(turn==4) {
					turn = 0;
					if(d>0) {
						r += dr[d-1];
						c += dc[d-1];
					}
					else {
						r += dr[3];
						c += dc[3];
					}
					if(map[r][c] == 1) 
						break;
				}
				// 방향 전환.
				else {
					if(d>0)
						d--;
					else
						d=3;
					turn++;
				}
			}
		}
		System.out.println(answer);
	}
}
