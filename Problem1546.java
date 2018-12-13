import java.util.Scanner;

public class Problem1546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		double[] score = new double[N];
		double max = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			score[i] = scanner.nextInt();
			if(score[i] >= max)
				max = score[i];
		}
		
		double sum = 0;
		for(int i=0; i<N; i++) {
			score[i] = score[i] / max * 100;
			sum += score[i];
		}
		
		System.out.printf("%.2f", sum / N);
	}

}
