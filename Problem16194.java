import java.util.Arrays;
import java.util.Scanner;

public class Problem16194 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] P = new int[N+1];
		for(int i=1; i<N+1;i ++)
			P[i] = scanner.nextInt();
		int[] d = new int[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		P[0] = 0;
		d[0] = 0;
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<=i; j++) {
				d[i] = Math.min(d[i], d[i-j] + P[j]);
			}
		}
		System.out.println(d[N]);
	}
}
