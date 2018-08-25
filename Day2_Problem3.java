import java.util.Scanner;
import java.util.Stack;

public class Day2_Problem3 {
	static int N;
	static int[][] map;
	static int answer;
	static int count;
	static Stack<Integer> rowStack;
	static Stack<Integer> colStack;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		map = new int[N][N];
		rowStack = new Stack<Integer>();
		colStack = new Stack<Integer>();
		
		search();
		System.out.println(answer);
	}
	
	public static void search() {
		if(count < N) {
			for(int row = 0; row<N; row++) {
				for(int col=0; col<N; col++) {
					if(map[row][col] == 0) {
						map[row][col] = 1;
						rowStack.push(row);
						colStack.push(col);
						count++;
						search();
						count--;
					}
				}
			}
		}
		// 이제 겹치는 부분 없나 확인해보자.
		else {
			System.out.println();
			System.out.println();
			for(int row=0; row<N; row++) {
				for(int col=0; col<N; col++) {
					System.out.print(map[row][col] + " ");
				}
				System.out.println();
			}
			int queenRow;
			int queenCol;
			
			while(!rowStack.isEmpty() && !colStack.isEmpty()) {
				queenRow = rowStack.pop();
				queenCol = colStack.pop();
				
				// 세로 확인.
				for(int col=0; col<N; col++) {
					if(map[queenRow][col] == 1) {
						map[queenRow][queenCol] = 0;
						return;
					}
				}
				
				// 가로 확인.
				for(int row=0; row<N; row++) {
					if(map[row][queenCol] == 1) {
						map[queenRow][queenCol] = 0;
						return;
					}
				}
				
				for(int i=-N; i<N && queenRow + i >= 0 && queenRow + i < N && queenCol + i >= 0 && queenCol + i < N; i++) {
					if(map[queenRow + i][queenCol + 1] == 1) {
						map[queenRow][queenCol] = 0;
						return;
					}
					if(map[queenRow + i][queenCol - i] == 1) {
						map[queenRow][queenCol] = 0;
						return;
					}
				}
			}
			answer++;
			
		}
		
	}
}
