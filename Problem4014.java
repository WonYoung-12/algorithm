import java.util.Scanner;

public class Problem4014 {
	static int N;
	static int X;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		// 배열 가로세로 크기.

		for (int t = 0; t < T; t++) {
			N = scanner.nextInt();
			int[][] map = new int[N][N];
			// 경사로 길이. 경사로의 높이는 1.
			X = scanner.nextInt();
			// 행 또는 열을 복사해서 검사할 배열.
			int[] check = new int[N];
			int answer = 0;

			for (int row = 0; row < N; row++)
				for (int col = 0; col < N; col++)
					map[row][col] = scanner.nextInt();

			// 행검사.
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					check[col] = map[row][col];
				}
				if (search(check))
					answer++;
			}

			// 열검사.
			for (int col = 0; col < N; col++) {
				for (int row = 0; row < N; row++) {
					check[row] = map[row][col];
				}
				if (search(check))
					answer++;
			}
			System.out.println("#" + (t + 1) + " " + answer);
		}
	}

	public static boolean search(int[] array) {
		// 경사로 설치한 곳인지 체크하는 배열.
		boolean[] c = new boolean[N];

		for (int i = 0; i < N - 1; i++) {
			// 다르면 경사로.
			if (array[i] != array[i + 1]) {
				int diff = array[i + 1] - array[i];
				if (diff < 0)
					diff = -diff;
				// 높이 차이가 1이 아니면 의미가 없음.
				if (diff != 1)
					return false;
				if (array[i] < array[i + 1]) {
					for (int j = 1; j <= X; j++) {
						// 배열 밖으로 넘어 가는 경우.
						if (i + 1 - j < 0)
							return false;
						// 연속된 지형의 높이가 다를 경우.
						if (array[i] != array[i + 1 - j])
							return false;
						if (c[i + 1 - j])
							return false;
						c[i + 1 - j] = true;
					}
				}
				// array[i] > array[i+1]
				else {
					for (int j = 1; j <= X; j++) {
						if (i + j > N - 1)
							return false;
						if (array[i + 1] != array[i + j])
							return false;
						if (c[i + j])
							return false;
						c[i + j] = true;
					}
				}
			}

		}
		return true;
	}
}
