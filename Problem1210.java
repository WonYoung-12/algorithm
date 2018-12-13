import java.util.Arrays;
import java.util.Scanner;

public class Problem1210 {
	static int T = 10;
	static int fromRow;
	static int fromCol;
	static int toRow;
	static int toCol;
	static boolean turning = false;
	static boolean toLeft = false;

	static int[][] map = new int[102][102];

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		for (int t = 0; t < T; t++) {
			scanner.nextInt();

			for (int row = 1; row < 101; row++) {
				for (int col = 1; col < 101; col++) {
					if ((map[row][col] = scanner.nextInt()) == 2) {
						fromRow = row;
						fromCol = col;
					}
				}
			}

			// make logic.
			move(fromRow, fromCol);
			System.out.println("#" + (t + 1) + " " + (toCol - 1));
		}
		scanner.close();
	}

	public static void move(int row, int col) {
		while(row > 1) {
			if(map[row][col-1] == 1) {
				while(map[row][col-1] == 1)
					col--;
				row--;
			}
			else if(map[row][col+1] == 1) {
				while(map[row][col+1] == 1)
					col++;
				row--;
			}
			else
				row--;
		}
		toCol = col;
	}
}
