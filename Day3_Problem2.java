import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Day3_Problem2 {
	static int[][] graph = new int[10001][10001];
	static int T;
	static int x;
	static int y;
	static int[] depth = new int[10001];
	static int answer;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// T = scanner.nextInt();
		// for(int t=0; t<T; t++) {
		//
		// }
		x = scanner.nextInt();
		y = scanner.nextInt();

		// int[][] tree = {{8, 5}, {8, 4}, {8, 1}, {5, 9}, {4, 6}, {4, 10}, {1, 14}, {1,
		// 13},
		// {6, 15}, {6, 7}, {10, 11}, {10, 16}, {10, 2}, {16, 3}, {16, 12}};
		// int[][] tree = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 5}, {2, 6}, {6, 7}};
//		int[][] tree = { { 1, 14 }, { 8, 5 }, { 10, 16 }, { 5, 9 }, { 4, 6 }, { 8, 4 }, { 4, 10 }, { 1, 13 }, { 6, 15 },
//				{ 10, 11 }, { 6, 7 }, { 10, 2 }, { 16, 3 }, { 8, 1 }, { 16, 12 }};

		int[][] tree = {{2, 3}, {3, 4}, {3, 1}, {1, 5}};
		for (int row = 0; row < tree.length; row++) {
			graph[tree[row][0]][tree[row][1]] = 1;
		}

		Arrays.fill(depth, -100000);
		for (int row = 0; row < tree.length; row++) {
			if (depth[tree[row][0]] == -100000) {
				if (depth[tree[row][1]] != -100000) {
					depth[tree[row][0]] = depth[tree[row][1]] - 1;
				} else {
					depth[tree[row][0]] = 0;
					depth[tree[row][1]] = 1;
				}
			} else {
				if (depth[tree[row][1]] == -100000) {
					depth[tree[row][1]] = depth[tree[row][0]] + 1;
				} else {
					if (depth[tree[row][0]] + 1 > depth[tree[row][1]]) {
						depth[tree[row][1]] = depth[tree[row][0]] + 1;
						for (int i = 0; i < 10001; i++) {
							if (graph[tree[row][1]][i] == 1) {
//								System.out.println(tree[row][1] + "의 자식은 " + i);
								depth[i] = depth[tree[row][1]] + 1;
								
								boolean isFirst = true;
								Stack<Integer> stack = new Stack<Integer>();
								int[] visited = new int[10001];
								Arrays.fill(visited, 0);
								stack.push(i);
								while(!stack.isEmpty()) {
									isFirst = true;
									int temp = stack.pop();
									visited[temp] = 1;
									
									for(int node=1; node<10001; node++) {
										if(graph[temp][node] == 1 && visited[node] == 0) {
											if(isFirst) {
												isFirst = false;
												stack.push(temp);
											}
											stack.push(node);
											depth[node] = depth[temp] + 1;
										}
									}
								}
							}
						}
					}
				}
			}
		}

		scanner.close();
		setDepth();    
		searchAnswer();
		System.out.println(answer);
	}

	public static void setDepth() {
		if (depth[x] > depth[y]) {
			while (true) {
				for (int node = 0; node < 10001; node++) {
					if (graph[node][x] == 1 && depth[node] == depth[x] - 1) {
						x = node;
						break;
					}
				}
				if (depth[x] == depth[y]) {
					break;
				}
			}
		} else if (depth[y] > depth[x]) {
			while (true) {
				for (int node = 0; node < 10001; node++) {
					if (graph[node][y] == 1 && depth[node] == depth[y] - 1) {
						y = node;
						break;
					}
				}
				if (depth[y] == depth[x]) {
					break;
				}
			}
		} else
			return;
	}

	public static void searchAnswer() {
		if (x == y) {
			answer = x;
			return;
		}

		for (int node = 0; node < 10001; node++) {
			if (graph[node][x] == 1 && depth[node] == depth[x] - 1) {
				x = node;
				break;
			}
		}

		for (int node = 0; node < 10001; node++) {
			if (graph[node][y] == 1 && depth[node] == depth[y] - 1) {
				y = node;
				break;
			}
		}

		searchAnswer();
	}
}
