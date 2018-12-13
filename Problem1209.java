import java.util.Scanner;

public class Problem1209 {
	private static final int T = 10;
	private static final int N = 100;
	private static final Scanner scanner = new Scanner(System.in);
	private static int[][] array = new int[N][N];
	private static int answer;

	public static void main(String[] args) {
		// 각 test case.
		for (int i = 0; i < T; i++) {
			scanner.nextInt();

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					array[j][k] = scanner.nextInt();
				}
			}

			// input finish. make logic.
			answer = Math.max(Math.max(rowSum(), columnSum()), diagonalSum());
			System.out.println("#" + (i+1) + " " + answer);
		}
	}

	static int rowSum() {
		int max = 0;

		for (int i = 0; i < N; i++) {
			int temp = 0;
			for (int j = 0; j < N; j++) {
				temp += array[i][j];
			}
			if (temp > max)
				max = temp;
		}

		return max;
	}

	static int columnSum() {
		int max = 0;

		for (int i = 0; i < N; i++) {
			int temp = 0;
			for (int j = 0; j < N; j++) {
				temp += array[j][i];
			}
			if (temp > max)
				max = temp;
		}

		return max;
	}

	static int diagonalSum() {
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < N; i++)
			sum1 += array[i][i];

		for (int i = 0; i < N; i++)
			sum2 += array[N - 1 - i][i];

		if (sum1 >= sum2)
			return sum1;

		return sum2;
	}
}
