import java.util.Scanner;

public class Problem1206 {
	private static final int T = 10;
	private static int length;
	private static int[] array;
	private static Scanner scanner = new Scanner(System.in);
	private static int answer = 0;
	
	public static void main(String[] args) {
		for(int i=0; i<T; i++) {
			answer = 0;
			length = scanner.nextInt();
			array = new int[length];
			for(int j=0; j<length; j++){
				array[j] = scanner.nextInt();
			}
			
			// logic.
			for(int k=2; k<length-2; k++) {
				if(array[k] > array[k-1] && array[k] > array[k-2] && array[k] > array[k+1] && array[k] > array[k+2]) {
					answer += array[k] - Math.max(Math.max(array[k-1], array[k-2]), Math.max(array[k+1], array[k+2]));
				}
			}
			System.out.println("#" + (i+1) + " " + answer);
		}
	}
}
