import java.util.Scanner;

public class Problem10844 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		// 길이가 N, 마지막에 사용한 수 J.
		int[][] d = new int[N+1][10];
		for(int i=1; i<=9; i++)
			d[1][i] = 1;
		for(int i=2; i<=N; i++) {
			for(int j=0; j<=9; j++) {
				d[i][j] = 0;
				if(j-1 >= 0)
					d[i][j] += d[i-1][j-1];
				if(j+1 <= 9)
					d[i][j] += d[i-1][j+1];
				d[i][j] %= 1000000000;
			}
		}
		long answer = 0;
		for(int i=0; i<=9; i++)
			answer += d[N][i];
		answer %= 1000000000;
		System.out.println(answer);
	}
}
