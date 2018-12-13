import java.util.Scanner;

public class Problem1213 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			int answer = 0;
			scanner.nextLine();
			String keyword = scanner.nextLine();
			int length = keyword.length();
			String line = scanner.nextLine();
			
			while(line.contains(keyword)) {
				answer++;
				int index = line.indexOf(keyword);
				line = line.substring(index + length);
			}
			System.out.println("#" + (i+1) + " " + answer);
		}
	}
}
