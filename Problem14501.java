import java.util.Scanner;

public class Problem14501 {
	static int[][] schedule;
	static int N;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		
		schedule = new int[2][N];
		for(int i=0; i<N; i++) {
			schedule[0][i] = scanner.nextInt();
			schedule[1][i] = scanner.nextInt();
		}
		quit(0,0);
		System.out.println(answer);
	}
	
	public static void quit(int num, int sum) {
		if(num == N) {
			if(sum>answer)
				answer = sum;
			return;
		}
		if(num > N)
			return;
		quit(num + schedule[0][num], sum + schedule[1][num]);
		quit(num + 1, sum);
	}
}
