import java.util.Arrays;
import java.util.Scanner;

public class Day2_Problem3 {
	// N개의 행, 각 인덱스가 각 행의 몇 번째 열에 퀸이 존재하는가.
	static int[] rows;
	static int N;
	static int answer;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		rows = new int[N];

		Arrays.fill(rows, -1);
		setQueens(0);
		System.out.println(answer);
		scanner.close();
	}

	public static void setQueens(int rowNum) {
		if (rowNum == N) {
			answer++;
			return;
		}
		for (int col = 0; col < N; col++) {
			if (check(rowNum, col)) {
				rows[rowNum] = col;
				setQueens(rowNum + 1);
				rows[rowNum] = -1;
			}
		}
	}

	// 현재 이 row, col에 퀸을 두어도 되는지 체크.
	public static boolean check(int rowNum, int colNum) {
		if (rowNum == 0)
			return true;
		// 현재까지의 행 중에 규칙 위반하는 것이 없는지 확인한다.
		// || 뒤의 조건은 대각선 체크.
		for (int i = 0; i < rowNum; i++) {
			if (rows[i] == colNum || rowNum - i == Math.abs(rows[i] - colNum)) 
				return false;
		}
		return true;
	}
}
