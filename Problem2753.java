import java.util.Scanner;

public class Problem2753 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();

		int answer = 0;
		// 4의 배수.
		if (year % 4 == 0) {
			// 100의 배수가 아닐 때.
			if (year % 100 != 0)
				answer = 1;
			else {
				// 400의 배수일때.
				if (year % 400 == 0)
					answer = 1;
			}
		}
		System.out.println(answer);
	}
}
