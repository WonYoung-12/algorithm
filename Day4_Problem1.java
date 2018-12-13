import java.util.Scanner;

public class Day4_Problem1 {
	static int N;
	static int M;
	static int[][] map;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		map = new int[N][M];

		scanner.nextLine();
		
		for (int row = 0; row < N; row++) {
			String line = scanner.nextLine();
			for(int i=0; i<line.length(); i++) {
				map[row][i] = line.charAt(i) - '0';
			}
		}
		
		for(int row=0; row<N; row++) {
			for(int col=0; col<M; col++) {
				System.out.print(map[row][col]);
			}
			System.out.println();
		}
				
	}
}
