import java.util.Scanner;

public class Problem15990 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int t=0; t<T; t++) {
			int N = scanner.nextInt();
			int[][] d = new int[N+1][4];
			
			for(int i=1; i<N+1; i++) {
				if(i >= 1) {
					d[i][1] = d[i-1][2] + d[i-1][3];
					if(i==1)
						d[i][1] = 1;
				}
				if(i >= 2) {
					d[i][2] = d[i-2][1] + d[i-2][3];
					if(i==2)
						d[i][2] = 1;
				}
				if(i >= 3) {
					d[i][3] = d[i-3][1] + d[i-3][2];
					if(i==3)
						d[i][3] = 1;
				}
				d[i][1] %= 1000000009;
				d[i][2] %= 1000000009;
				d[i][3] %= 1000000009;
			}
			System.out.println((d[N][1] + d[N][2] + d[N][3]) % 1000000009);
		}
	}
}
