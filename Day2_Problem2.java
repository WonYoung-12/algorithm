import java.util.Scanner;

public class Day2_Problem2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int nextNum;
		String s = "";
		
		while(num >= 10) {
			System.out.print(num + " ");
			s = String.valueOf(num);
			nextNum = 1;
			for(int i=0; i<s.length(); i++) {
				nextNum *= s.charAt(i) - '0';
			}
			num = nextNum;
		}
		System.out.println(num);
	}
}
