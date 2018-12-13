import java.util.Scanner;

public class Problem11052 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] P = new int[N+1];
		for(int i=1; i<N+1;i ++)
			P[i] = scanner.nextInt();
		int[] d = new int[N+1];
		P[0] = 0;
		d[0] = 0;
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<=i; j++) {
				d[i] = Math.max(d[i], d[i-j] + P[j]);
			}
		}
		System.out.println(d[N]);
	}
}
