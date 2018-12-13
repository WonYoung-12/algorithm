import java.util.Scanner;

public class Problem11727 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] d = new int[n+1];
		d[0] = 1;
		d[1] = 1;
		for(int i=2; i<n+1; i++) {
			d[i] = (d[i-1] + 2*d[i-2]) % 10007;
		}
		System.out.println(d[n]);
	}
}
