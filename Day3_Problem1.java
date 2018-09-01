import java.util.Scanner;

public class Day3_Problem1 {
	// 노드 갯수.
	static int N;
	// 엣지 갯수.
	static int M;
	// 연결되어 있는지 그래프로.
	static int[][] map;
	// 방문했는지 체크.
	static int[] visited;
	static int answer;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		map = new int[N+1][N+1];
		visited = new int[N+1];
		
		for(int i=0; i<M; i++) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			map[from][to] = map[to][from] = 1;
		}
		
		for(int i=1; i<N+1; i++) {
			if(visited[i] == 0) {
				search(i);
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	public static void search(int start) {
		visited[start] = 1;
		for(int i=1; i<N+1; i++) {
			if(map[start][i] == 1 && visited[i] == 0)
				search(i);
		}
	}
}
