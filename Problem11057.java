import java.util.Scanner;

public class Problem11057 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[][] d = new int[N+1][10];
		for(int i=0; i<=9; i++)
			d[1][i] = 1;
		
		for(int i=2; i<=N; i++) {
			for(int j=0; j<=9; j++) {
				for(int k=0; k<=j; k++) {
					d[i][j] += d[i-1][k];
					d[i][j] %= 10007;
				}
			}
		}
		int answer = 0;
		for(int i=0; i<=9; i++)
			answer += d[N][i];
		answer %= 10007;
		System.out.println(answer);
	}
}
