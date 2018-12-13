import java.util.Scanner;

public class Problem_14501 {
	static int[][] schedule;
	static int N;
	static int answer = Integer.MIN_VALUE;
	static int[] d;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		d = new int[N+1];
		
		schedule = new int[2][N];
		for(int i=0; i<N; i++) {
			schedule[0][i] = scanner.nextInt();
			schedule[1][i] = scanner.nextInt();
		}
		dp();
		System.out.println(d[N]);
	}
	
	public static void dp() {
		d[0] = 0;
		for(int i=1; i<N+1; i++) {
			for(int j=0; j<i; j++)
			if(j + schedule[0][j] <= i) {
				System.out.println("i : " + i);
				System.out.println("j : " + j);
				System.out.println("d[i] : " + d[i]);
				System.out.println("d[j] + scehdule : " + (d[j] + schedule[1][j]));
				d[i] = Math.max(d[i], d[j] + schedule[1][j]);
			}
			System.out.println();
		}
	}
}
