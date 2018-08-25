import java.util.Arrays;

public class Day2_Problem4 {
	static int[] answer = new int[7];
	static int[] myAnswer = new int[7];
	static int[] arr = {20, 7, 23, 19, 10, 15, 25, 8, 13};
	static boolean isAnswer = false;
	public static void main(String[] args) {
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
				myAnswer[i] = answer[i];
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
