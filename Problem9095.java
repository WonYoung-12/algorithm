import java.util.Scanner;

public class Problem9095 {
	static int[] d;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int t=0; t<T; t++) {
			int n = scanner.nextInt();
			d = new int[n+1];
			if(n == 1) {
				System.out.println(1);
				continue;
			}
			d[0] = 1;
			d[1] = 1;
			d[2] = 2;
			search(n);
			System.out.println(d[n]);
		}
	}
	public static void search(int n) {
		for(int i=3; i<n+1; i++) {
			d[i] = d[i-1] + d[i-2] + d[i-3];
		}
	}
}
