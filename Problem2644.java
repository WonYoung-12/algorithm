import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2644 {
	// 사람의 수.
	static int n;
	static int[][] graph;
	static int[] distance;
	static int[] visited;
	static int start;
	static int end;
	// 관계의 수.
	static int m;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		graph = new int[n + 1][n + 1];
		distance = new int[n + 1];
		visited = new int[n + 1];
		start = scanner.nextInt();
		end = scanner.nextInt();
		m = scanner.nextInt();
		for (int i = 0; i < m; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		search();
		if(distance[end] != 0)
			System.out.println(distance[end]);
		else 
			System.out.println(-1);
	}

	public static void search() {
		Queue queue = new LinkedList();
		queue.add(start);
		while (!queue.isEmpty()) {
			int current = (int) queue.poll();
			visited[current] = 1;
			for (int i = 0; i < n + 1; i++) {
				if (graph[current][i] == 1 && visited[i] == 0) {
					queue.add(i);
					distance[i] = distance[current] + 1;
				}
			}
		}
	}
}
