import java.util.Arrays;
import java.util.Scanner;

public class Problem2309 {
	static int[] answer = new int[7];
	static int[] arr = new int[9];
	static boolean isAnswer = false;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<9; i++)
			arr[i] = scanner.nextInt();
		search(0, 0, 0);
	}
	
	public static void search(int start, int sum, int count) {
		if(isAnswer)
			return;
		if(sum > 100)
			return;
		if(count == 7 && sum == 100) {
			Arrays.sort(answer);
			isAnswer = true;
			for(int i=0; i<7; i++)
				System.out.println(answer[i]);
			return;
		}
		if(count == 7 && sum != 100)
			return;

		for(int i=start; i<9; i++) {
			answer[count] = arr[i];
			search(i+1, sum + arr[i], count + 1);
			answer[count] = 0;
		}
	}
}
