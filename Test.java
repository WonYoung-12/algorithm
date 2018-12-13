import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = new int[101];
		
		for(int i=0; i<1000; i++) {
			array[scanner.nextInt()]++;
		}
		
		for(int i=0; i<101; i++)
			System.out.println(i + " : " + array[i]);
	}
}
