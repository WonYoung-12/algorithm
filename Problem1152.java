import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem1152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		scanner.close();
		StringTokenizer st = new StringTokenizer(line, " ");
		
		int answer = 0;
		
		while(st.hasMoreTokens()) {
			st.nextToken();
			answer++;
		}
		System.out.println(answer);
	}

}
