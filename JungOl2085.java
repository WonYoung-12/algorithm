import java.util.Scanner;

public class JungOl2085 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int start = scanner.nextInt();
		int end = scanner.nextInt();
		
		// 1	년부터 start지 윤년의 수에서 1년부터 end까지 윤년의 수를 빼면 정답.
		int answer = (start / 4 - start / 100 + start / 400) - (end / 4 - end / 100 + end / 400);
		System.out.println(answer);
	}
}
