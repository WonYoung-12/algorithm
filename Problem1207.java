import java.util.Arrays;
import java.util.Scanner;

public class Problem1207 {
	private static int[] array = new int[100];
	private static final int T = 10;
	private static int dump;
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Arrays.fill(array, 0);
		for(int i=0; i<T; i++) {
			dump = scanner.nextInt();
			for(int j=0; j<100; j++) {
				array[j] = scanner.nextInt();
			}
			// logic.
			move(array, dump);
			Arrays.sort(array);
			System.out.println("#" + (i+1) + " " + (array[99]-array[0]));
		}
	}
	
	public static void move(int[] array, int dump) {
		if(dump == 0)
			return;
		
		Arrays.sort(array);
		array[0]++;
		array[99]--;
		move(array, dump-1);
	}
}
