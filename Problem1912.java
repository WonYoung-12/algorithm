import java.util.Scanner;

public class Problem1912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] input = new int[n+1];
		int[] dp = new int[n+1];
		int answer = Integer.MIN_VALUE;
		
		for(int i=1; i<n+1; i++) {
			input[i] = scanner.nextInt();
		}
		
		dp[0] = 0;
		input[0] = 0;
		
		for(int i=1; i<n+1; i++) {
			dp[i] = Math.max(dp[i-1] + input[i], input[i]);
			if(dp[i] >= answer)
				answer = dp[i];
		}
		
		System.out.println(answer);
	}

}
