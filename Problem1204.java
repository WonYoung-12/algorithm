import java.util.Scanner;

public class Problem1204 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = 10;
		
		// Logic.
		for(int i=0; i<T; i++) {
			int num = scanner.nextInt();
			
			int[] array = new int[101];
			int answerPoint = 0;
			int answer = 0;
			
			for(int j=0; j<1000; j++) {
				array[scanner.nextInt()]++;
			}
			
			for(int k=0; k<101; k++) {
				if(array[k] >= answerPoint) {
					answerPoint = array[k];
					answer = k;
				}
			}
			System.out.println("#" + num + " " + answer);
		}
	}
}
