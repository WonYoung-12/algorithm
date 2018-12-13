import java.util.Scanner;

public class Problem1157 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int[] alpha = new int[26];
		
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		// 같은게 여러개인지 체크.
		boolean check = false;
		
		String line = scanner.nextLine().toLowerCase();
		for(int i=0; i<line.length(); i++) {
			alpha[line.charAt(i)-'a']++;
		}
		
		for(int i=0; i<alpha.length; i++) {
			if(alpha[i] > max) {
				max = alpha[i];
				maxIndex = i;
				check = false;
			}
			else if(alpha[i] == max) {
				check = true;
			}
		}
		
		if(check)
			System.out.println("?");
		else {
			System.out.println((char)('A' + maxIndex));
		}
	}

}
