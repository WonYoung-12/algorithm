import java.util.Scanner;

public class Problem1217 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int t=0; t<10; t++) {
			int answer = 0;
			int num = scanner.nextInt();
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			
			answer = pow(N, M);
			System.out.println("#" + (t+1) + " " + answer);
		}
	}
	
	public static int pow(int N, int M) {
		if(M==1)
			return N;
		return pow(N, M-1) * N;
	}
}
