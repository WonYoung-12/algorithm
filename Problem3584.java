import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Problem3584 {
	static int T;
	static int N;
	static int x;
	static int y;
	static int[][] tree;
	static int[] depth;
	static int answer;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		for (int t = 0; t < T; t++) {
			N = scanner.nextInt();
			tree = new int[N - 1][2];
			depth = new int[N+1];
			for (int i = 0; i < N - 1; i++) {
				tree[i][0] = scanner.nextInt();
				tree[i][1] = scanner.nextInt();
			}
			x = scanner.nextInt();
			y = scanner.nextInt();

			calculateDepth();
			setDepth();
			searchAnswer();
			System.out.println(answer);
		}

		scanner.close();
	}
	
	public static void calculateDepth() {
		Arrays.fill(depth, -1);
		for (int row = 0; row < tree.length; row++) {
			if (depth[tree[row][0]] == -1) {
				if (depth[tree[row][1]] != -1) {
					depth[tree[row][0]] = depth[tree[row][1]] - 1;
				} else {
					depth[tree[row][0]] = 0;
					depth[tree[row][1]] = 1;
				}
			} else {
				if (depth[tree[row][1]] == -1) {
					depth[tree[row][1]] = depth[tree[row][0]] + 1;
				} else {
					if (depth[tree[row][0]] + 1 > depth[tree[row][1]]) {
						depth[tree[row][1]] = depth[tree[row][0]] + 1;
						for(int edge = 0; edge<N-1; edge++) {
							if(tree[edge][0] == tree[row][1]) {
								depth[tree[edge][1]] = depth[tree[edge][0]] + 1;
								
								boolean isFirst = true;
								Stack<Integer> stack = new Stack<Integer>();
								int[] visited = new int[N+1];
								Arrays.fill(visited, 0);
								stack.push(tree[edge][1]);
								while (!stack.isEmpty()) {
									isFirst = true;
									int parent = stack.pop();
									visited[parent] = 1;

									for (int tEdge = 0; tEdge < N-1; tEdge++) {
										if (tree[tEdge][0] == parent && visited[tree[tEdge][1]] == 0) {
											int child = tree[tEdge][1];
											visited[child] = 1;
											if (isFirst) {
												isFirst = false;
												stack.push(parent);
											}
											stack.push(child);
											depth[child] = depth[parent] + 1;
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public static void setDepth() {
		if (depth[x] > depth[y]) {
			while (true) {
				for(int edge = 0; edge < N-1; edge++) {
					if(tree[edge][1] == x) {
						x = tree[edge][0];
						break;
					}
				}
				if (depth[x] == depth[y]) {
					break;
				}
			}
		} else if (depth[y] > depth[x]) {
			while (true) {
				for(int edge = 0; edge < N-1; edge++) {
					if(tree[edge][1] == y) {
						y = tree[edge][0];
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

		for (int edge = 0; edge < N-1; edge++) {
			if (tree[edge][1] == x) {
				x = tree[edge][0];
				break;
			}
		}

		for (int edge = 0; edge < N-1; edge++) {
			if (tree[edge][1] == y) {
				y = tree[edge][0];
				break;
			}
		}

		searchAnswer();
	}
}
