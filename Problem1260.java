import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Problem1260 {
	static int N;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		int M = scanner.nextInt();
		int start = scanner.nextInt();

		int[][] map = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			map[from][to] = map[to][from] = 1;
		}

		dfs(map, start);
		System.out.println();
		bfs(map, start);
	}

	public static void dfs(int[][] map, int start) {
		int[] visited = new int[N+1];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(start);
		visited[start] = 1;
		System.out.print(start + " ");
		
		while(!stack.isEmpty()) {
			int from = stack.pop();
			for(int i=1; i<N+1; i++) {
				if(map[from][i] == 1 && visited[i] == 0) {
					stack.push(from);
					stack.push(i);
					visited[i] = 1;
					System.out.print(i + " ");
					break;
				}
			}
		}
	}

	public static void bfs(int[][] map, int start) {
		int[] visited = new int[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start] = 1;
		System.out.print(start + " ");
		
		while(!queue.isEmpty()) {
			int from = queue.poll();
			if(visited[from] == 0)
				System.out.print(from + " ");
			visited[from] = 1;
			
			for(int i=1; i<N+1; i++) {
				if(map[from][i] == 1 && visited[i] == 0) {
					queue.add(i);
				}
			}
		}
	}
}
