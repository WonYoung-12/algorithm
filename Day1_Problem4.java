import java.util.Scanner;
import java.util.StringTokenizer;

public class Day1_Problem4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		
		StringTokenizer st = new StringTokenizer(line, " ");
		int answer = 0;
		while(st.hasMoreTokens()) {
			st.nextToken();
			answer++;
		}
		System.out.println(answer);
	}
}
