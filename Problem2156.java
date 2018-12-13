import java.util.Scanner;

// 안 마시는 포도주의 위치에 따라 경우를 나누어 주자.
public class Problem2156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] drink = new int[n + 1];
		int[] dp = new int[n + 1];

		for (int i = 0; i < n; i++) {
			drink[i + 1] = scanner.nextInt();
		}
		drink[0] = 0;
		dp[0] = 0;
		dp[1] = drink[1];
		if (n < 2)
			System.out.println(dp[n]);
		else {
			dp[2] = drink[1] + drink[2];
			if (n >= 3) {
				for (int i = 3; i < n + 1; i++) {
					dp[i] = Math.max(dp[i - 3] + drink[i - 1] + drink[i], 
							Math.max(dp[i - 2] + drink[i], dp[i - 1]));
				}
			}
			System.out.println(dp[n]);
		}
	}

}
