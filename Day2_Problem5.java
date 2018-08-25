import java.util.Scanner;

public class Day2_Problem5 {
	static int k;
	static int[] S;
	static int[] answer;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		k = scanner.nextInt();
		S = new int[k];
		answer = new int[k-1];
		
		for(int i=0; i<k; i++)
			S[i] = scanner.nextInt();
		
		search(0, 0);
	}
	
	public static void search(int start, int count) {
		if(count == 6) { 
			for(int i=0; i<6; i++)
				System.out.print(answer[i] + " ");
			System.out.println();
			return;
		}
		for(int i = start; i<k; i++) {
			answer[count] = S[i];
			search(i + 1, count+1);
			answer[count] = 0;
		}
	}
}

