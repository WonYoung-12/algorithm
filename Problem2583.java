import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem2583 {
	// 행.
	static int M;
	// 칼럼.
	static int N;
	// 직사각형 개수.
	static int K;
	static int[][] map;
	static int[][] visited;

	static int count = 0;
	static int area = 0;
	static ArrayList areaList = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		M = scanner.nextInt();
		N = scanner.nextInt();
		map = new int[M][N];
		visited = new int[M][N];

		K = scanner.nextInt();
		// 맵 초기화.
		for (int i = 0; i < K; i++) {
			int x1 = scanner.nextInt();
			int y1 = scanner.nextInt();
			int x2 = scanner.nextInt();
			int y2 = scanner.nextInt();

			// 1은 가로 막히는 벽. 0은 갈 수 있는 곳.
			for (int row = M - y2; row < M - y1; row++) {
				for (int column = x1; column < x2; column++) {
					map[row][column] = 1;
				}
			}
		}
		for (int row = 0; row < M; row++) {
			for (int column = 0; column < N; column++) {
				if (map[row][column] == 0 && visited[row][column] == 0) {
					count++;
					search(row, column);
					areaList.add(area);
					area = 0;
				}
			}
		}
		System.out.println(count);
		Collections.sort(areaList);
		for(int i=0; i<areaList.size();i++) {
			System.out.print(areaList.get(i) + " ");
		}
	}

	public static void search(int startRow, int startColumn) {
		visited[startRow][startColumn] = 1;
		area++;

		// 왼쪽.
		if (startColumn - 1 >= 0 && map[startRow][startColumn - 1] == 0 && visited[startRow][startColumn - 1] == 0) {
			search(startRow, startColumn - 1);
		}
		// 위쪽.
		if (startRow - 1 >= 0 && map[startRow - 1][startColumn] == 0 && visited[startRow - 1][startColumn] == 0) {
			search(startRow - 1, startColumn);
		}
		// 오른쪽.
		if (startColumn + 1 < N && map[startRow][startColumn + 1] == 0 && visited[startRow][startColumn + 1] == 0) {
			search(startRow, startColumn + 1);
		}
		// 아래쪽.
		if (startRow + 1 < M && map[startRow + 1][startColumn] == 0 && visited[startRow + 1][startColumn] == 0) {
			search(startRow + 1, startColumn);
		}
	}
}
