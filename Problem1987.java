import java.util.Scanner;
import java.util.Stack;

public class Problem1987 {
	static int R;
	static int C;

	static int answer = 0;

	static char[][] board;
	static int[] checked;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		R = scanner.nextInt();
		C = scanner.nextInt();
		scanner.nextLine();

		board = new char[R][C];
		checked = new int[26];

		for (int i = 0; i < R; i++) {
			String line = scanner.nextLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		scanner.close();

		dfs(0, 0, 1);
		System.out.println(answer);
	}

	public static void dfs(int startRow, int startColumn, int currentAnswer) {
		if (currentAnswer > answer)
			answer = currentAnswer;

		checked[board[startRow][startColumn] - 'A'] = 1;

		// 왼쪽.
		if (startColumn - 1 >= 0 && checked[board[startRow][startColumn - 1] - 'A'] == 0) {
			dfs(startRow, startColumn - 1, currentAnswer + 1);
			checked[board[startRow][startColumn - 1] - 'A'] = 0;
		}

		// 위쪽.
		if (startRow - 1 >= 0 && checked[board[startRow - 1][startColumn] - 'A'] == 0) {
			dfs(startRow - 1, startColumn, currentAnswer + 1);
			checked[board[startRow - 1][startColumn] - 'A'] = 0;
		}

		// 오른쪽.
		if (startColumn + 1 < C && checked[board[startRow][startColumn + 1] - 'A'] == 0) {
			dfs(startRow, startColumn + 1, currentAnswer + 1);
			checked[board[startRow][startColumn + 1] - 'A'] = 0;
		}

		// 아래쪽.
		if (startRow + 1 < R && checked[board[startRow + 1][startColumn] - 'A'] == 0) {
			dfs(startRow + 1, startColumn, currentAnswer + 1);
			checked[board[startRow + 1][startColumn] - 'A'] = 0;
		}
	}
}
