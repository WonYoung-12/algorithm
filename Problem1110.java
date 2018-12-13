import java.util.Scanner;

public class Problem1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		int input;
		int num;
		int answer = 0;

		if (line.length() < 2) {
			line = "0" + line;
		}
		input = Integer.parseInt(line);
		num = input;

		while (true) {
			answer++;
			int left = num / 10;
			int right = num % 10;
			num = right * 10 + (left + right) % 10;
			if (num == input) {
				break;
			}
		}

		System.out.println(answer);
	}

}
