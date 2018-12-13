import java.util.Scanner;

public class Problem2163 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		
		System.out.println((N-1) + N * (M-1));
	}
}
