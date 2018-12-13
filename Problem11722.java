import java.util.Scanner;

public class Problem11722 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] array = new int[N];
		// i부터 가장 큰 감소하는 수열의 길
		int[] dp = new int[N];
		int answer = 0;
		
		for(int i=0; i<array.length; i++) {
			array[i] = scanner.nextInt();
			dp[i] = 1;
		}
		
		// 찾자.
		for(int i=0; i<dp.length; i++) {
			for(int j=array.length - 1; j>=0; j--) {
				if(array[i] > array[j]) {
					dp[i] = Math.max(dp[i] + 1, dp[j]);
				}
			}
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}

}
