import java.util.Arrays;
import java.util.Scanner;

public class Lab {
	static int wallCount;
	static int N;
	static int M;
	static int[][] map;
	static int[][] copy;
	static int[][] temp;
	static int[][] visited;
	static int answer = Integer.MIN_VALUE;

	static int[] dRow = { 0, 1, 0, -1 };
	static int[] dCol = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		map = new int[N + 2][M + 2];
		copy = new int[N + 2][M + 2];
		temp = new int[N + 2][M + 2];
		visited = new int[N + 2][M + 2];

		for (int row = 0; row < N + 2; row++) {
			Arrays.fill(map[row], 1);
			Arrays.fill(copy[row], 1);
		}

		for (int row = 1; row < N + 1; row++)
			for (int col = 1; col < M + 1; col++)
				map[row][col] = scanner.nextInt();

		for (int row = 1; row < N + 1; row++)
			for (int col = 1; col < M + 1; col++)
				copy[row][col] = map[row][col];

		// setWall
		setWall();

		System.out.println(answer);
	}

	public static void setWall() {
		if (wallCount < 3) {
			for (int row = 0; row < N + 2; row++) {
				for (int col = 0; col < M + 2; col++) {
					if (copy[row][col] == 0) {
						copy[row][col] = 1;
						wallCount++;
						setWall();
						copy[row][col] = 0;
					}
				}
			}
		} else {
			setVirus();
		}
		wallCount--;
	}

	public static void setVirus() {
		for (int row = 0; row < N + 2; row++) {
			for (int col = 0; col < M + 2; col++) {
				temp[row][col] = copy[row][col];
			}
		}
		
		for (int row = 0; row < N + 2; row++) {
			for (int col = 0; col < M + 2; col++) {
				if(temp[row][col] == 2)
					dfs(row, col);
			}
		}

		int check = 0;
		for (int row = 0; row < N + 2; row++) {
			for (int col = 0; col < M + 2; col++) {
				if (temp[row][col] == 0) {
					check++;
				}
			}
		}

		if (check > answer)
			answer = check;

		// 끝났으니까 복구해주자.
		for (int row = 0; row < N + 2; row++)
			Arrays.fill(visited[row], 0);
	}

	public static void dfs(int row, int col) {
		visited[row][col] = 1;
		for (int i = 0; i < 4; i++) {
			if (temp[row + dRow[i]][col + dCol[i]] == 0 && visited[row + dRow[i]][col + dCol[i]] == 0) {
				temp[row + dRow[i]][col + dCol[i]] = 3;
				dfs(row + dRow[i], col + dCol[i]);
			}
		}
	}
}