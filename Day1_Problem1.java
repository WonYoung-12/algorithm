import java.util.Scanner;

public class Day1_Problem1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		int length = line.length();

		// 길이가 짝수.
		if (length % 2 == 0) {
			line = line.substring(length / 2 - 1, length / 2 + 1);
		}
		// 길이가 홀수.
		else {
			line = line.substring(length / 2, length / 2 + 1);
		}
		System.out.println(line);
	}
}
