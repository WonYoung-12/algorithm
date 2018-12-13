import java.util.ArrayList;
import java.util.Scanner;

public class Problem4012 {
	static int N;
	static int[][] array;
	static ArrayList<Integer> first = new ArrayList<Integer>();
	static ArrayList<Integer> second = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int t=0; t<T; t++) {
			N = scanner.nextInt();
			array = new int[N][N];

			for (int row = 0; row < N; row++)
				for (int col = 0; col < N; col++)
					array[row][col] = scanner.nextInt();

			System.out.println("#" + (t+1) + " " + setTeam(0));
		}
	}

	public static int setTeam(int num) {
		if (num == N) {
			if (first.size() != N / 2)
				return -1;
			if (second.size() != N / 2)
				return -1;

			int t1 = 0;
			int t2 = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					t1 += array[first.get(i)][first.get(j)];
					t2 += array[second.get(i)][second.get(j)];
				}
			}
			return Math.abs(t1 - t2);
		}

		int answer = Integer.MAX_VALUE;
		first.add(num);
		int t1 = setTeam(num + 1);
		if (t1 < answer && t1 != -1)
			answer = t1;
		first.remove(first.size() - 1);

		second.add(num);
		int t2 = setTeam(num + 1);
		if (t2 < answer && t2 != -1)
			answer = t2;
		second.remove(second.size() - 1);

		return answer;
	}
}
