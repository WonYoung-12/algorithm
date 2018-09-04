import java.util.Arrays;
import java.util.Stack;

public class Day3_Problem2 {
	static int N;
	static int x;
	static int y;
	static int[][] tree;
	static int[] depth;
	static int answer;

	public static void main(String[] args) {
		int[][] tree = { { 2, 3 }, { 3, 4 }, { 3, 1 }, { 1, 5 } };
		N = tree.length + 1;
		depth = new int[N + 1];
		x = 3;
		y = 5;
		calculateDepth(tree);
		setDepth(tree);
		searchAnswer(tree);
		System.out.println(answer);
	}

	public static void calculateDepth(int[][] tree) {
		// 노드가 10000이면 -1로 depth를 초기화 할때 문제가 될 수 있음.
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
						for (int edge = 0; edge < N - 1; edge++) {
							if (tree[edge][0] == tree[row][1]) {
								depth[tree[edge][1]] = depth[tree[edge][0]] + 1;

								boolean isFirst = true;
								Stack<Integer> stack = new Stack<Integer>();
								int[] visited = new int[N + 1];
								Arrays.fill(visited, 0);
								stack.push(tree[edge][1]);
								while (!stack.isEmpty()) {
									isFirst = true;
									int parent = stack.pop();
									visited[parent] = 1;

									for (int tEdge = 0; tEdge < N - 1; tEdge++) {
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

	public static void setDepth(int[][] tree) {
		if (depth[x] > depth[y]) {
			while (true) {
				for (int edge = 0; edge < N - 1; edge++) {
					if (tree[edge][1] == x) {
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
				for (int edge = 0; edge < N - 1; edge++) {
					if (tree[edge][1] == y) {
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

	public static void searchAnswer(int[][] tree) {
		if (x == y) {
			answer = x;
			return;
		}

		for (int edge = 0; edge < N - 1; edge++) {
			if (tree[edge][1] == x) {
				x = tree[edge][0];
				break;
			}
		}

		for (int edge = 0; edge < N - 1; edge++) {
			if (tree[edge][1] == y) {
				y = tree[edge][0];
				break;
			}
		}

		searchAnswer(tree);
	}
}
