import java.util.Arrays;
import java.util.Scanner;

public class Day2_Problem1 {
	static int[] num;
	static int N;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		num = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			permutation(i, 1 , "");
			Arrays.fill(num, 0);
		}
	}

	public static void permutation(int n, int count, String answer) {
		if(count == N) {
			answer = answer + n;
			System.out.println(answer);
		}
		
		if (num[n] == 0) {
			answer = answer + n + " ";
			num[n] = 1;
			for (int i = 1; i <= N; i++) {
				if (num[i] == 0) {
					permutation(i, count+1, answer);
					num[i] = 0;
				}
			}
		}
	}
}
