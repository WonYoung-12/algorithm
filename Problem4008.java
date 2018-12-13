import java.util.Scanner;

public class Problem4008 {
	static int plus;
	static int minus;
	static int multiply;
	static int div;
	static int N;
	static int[] array;
	
	static int max;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		int T = scanner.nextInt();
		
		for(int t=0; t<1; t++) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			N = scanner.nextInt();
			array = new int[N];
			
			for(int i=0; i<N; i++)
				array[i] = scanner.nextInt();
			
			plus = scanner.nextInt();
			minus = scanner.nextInt();
			multiply = scanner.nextInt();
			div = scanner.nextInt();
			
			
			func(0, array[0], plus, minus, multiply, div);
			System.out.println(max);
			System.out.println(min);
		}
	}
	
	public static void func(int index, int sum, int plus, int minus, int multiply, int div) {
		if(plus<0 || minus<0 || multiply<0 || div<0)
			return;
		
		if(index == N-1) {
			if(sum > max)
				max = sum;
			if(sum < min)
				min = sum;
			return;
		}
		
		func(index+1, sum+array[index+1], plus-1, minus, multiply, div);
		func(index+1, sum-array[index+1], plus, minus-1, multiply, div);
		func(index+1, sum*array[index+1], plus, minus, multiply-1, div);
		func(index+1, sum/array[index+1], plus, minus, multiply, div-1);
	}
}
