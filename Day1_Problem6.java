import java.util.Scanner;

public class Day1_Problem6 {
	static int rLength;
	static int cLength;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		rLength = scanner.nextInt();
		cLength = scanner.nextInt();
		int[][] paper = new int[rLength][cLength];
		
//		int[][] paper = {{1, 2, 3, 4, 5}, {5, 4, 3, 2, 1}, {2, 3, 4, 5, 6}, {6, 5, 4, 3, 2}, {1, 2, 1, 2, 1}};
//		rLength = paper.length;
//		cLength = paper[0].length;
		
		for(int row=0; row<rLength; row++) {
			for(int col=0; col<cLength; col++) {
				paper[row][col] = scanner.nextInt();
			}
		}
		
		int answer = 0;
		
		for(int row=0; row<rLength; row++) {
			for(int col=0; col<cLength; col++) {
				int temp = Math.max(Math.max(Math.max(Math.max(block1(paper, row, col), block2(paper, row, col)), 
						block3(paper, row, col)), block4(paper, row, col)), block5(paper, row, col));
				if(temp > answer)
					answer = temp;
			}
		}
		
		System.out.println(answer);
	}
	
	public static int block1(int[][] paper, int row, int col) {
		int sum1 = 0;
		int sum2 = 0;
		
		// ㅡ 모양.
		if(col + 3 < cLength) 
			sum1 = paper[row][col] + paper[row][col+1] + paper[row][col+2] + paper[row][col+3];
		// ㅣ 모양.
		if(row + 3 < rLength)
			sum2 = paper[row][col] + paper[row+1][col] + paper[row+2][col] + paper[row+3][col];
		
		return Math.max(sum1, sum2);
	}
	
	// 네모.
	public static int block2(int[][] paper, int row, int col) {
		if(col + 1 < cLength && row + 1 < rLength)
			return paper[row][col] + paper[row+1][col] + paper[row][col+1] + paper[row+1][col+1];

		return 0;
	}
	
	// L 모양 및 반전 & 시계방향으로 회전한 블록.
	public static int block3(int[][] paper, int row, int col) {
		int max = 0;
		
		if(row + 2 < rLength && col + 1 < cLength) {
			if(paper[row][col] + paper[row+1][col] + paper[row+2][col] + paper[row+2][col+1] > max)
				max = paper[row][col] + paper[row+1][col] + paper[row+2][col] + paper[row+2][col+1];
		}
		
		if(row + 1 < rLength && col + 2 < cLength) {
			if(paper[row][col] + paper[row+1][col] + paper[row][col+1] + paper[row][col+2] > max)
				max = paper[row][col] + paper[row+1][col] + paper[row][col+1] + paper[row][col+2];
		}
		
		if(col + 1 < cLength && row + 2 < rLength) {
			if(paper[row][col] + paper[row][col+1] + paper[row+1][col+1] + paper[row+2][col+1] > max)
				max = paper[row][col] + paper[row][col+1] + paper[row+1][col+1] + paper[row+2][col+1];
		}
		
		if(col + 2 < cLength && row - 1 >= 0) {
			if(paper[row][col] + paper[row][col+1] + paper[row][col+2] + paper[row-1][col+2] > max)
				max = paper[row][col] + paper[row][col+1] + paper[row][col+2] + paper[row-1][col+2];
		}
		
		// 좌우 반전.
		if(col + 1 < cLength && row - 2 >= 0) {
			if(paper[row][col] + paper[row][col+1] + paper[row-1][col+1] + paper[row-2][col+1] > max)
				max = paper[row][col] + paper[row][col+1] + paper[row-1][col+1] + paper[row-2][col+1];
		}
		
		if(col + 2 < cLength && row + 1 < rLength) {
			if(paper[row][col] + paper[row+1][col] + paper[row+1][col+1] + paper[row+1][col+2] > max)
				max = paper[row][col] + paper[row+1][col] + paper[row+1][col+1] + paper[row+1][col+2];
		}
		
		if(col + 1 < cLength && row + 2 < rLength) {
			if(paper[row][col] + paper[row][col+1] + paper[row+1][col] + paper[row+2][col] > max)
				max = paper[row][col] + paper[row][col+1] + paper[row+1][col] + paper[row+2][col];
		}
		
		if(col + 2 < cLength && row + 1 < rLength) {
			if(paper[row][col] + paper[row][col+1] + paper[row][col+2] + paper[row+1][col+2] > max)
				max = paper[row][col] + paper[row][col+1] + paper[row][col+2] + paper[row+1][col+2];
		}
		
		return max;
	}
	
	// ㄱㄴ 모양.
	public static int block4(int[][] paper, int row, int col) {
		int max = 0;
		
		// 맨 마지막 col+1이 col이여도 통과가 되었음.
		if(row + 2 < rLength && col + 1 < cLength) {
			if(paper[row][col] + paper[row+1][col] + paper[row+1][col+1] + paper[row+2][col+1] > max)
				max = paper[row][col] + paper[row+1][col] + paper[row+1][col+1] + paper[row+2][col+1];
		}
		
		if(row - 1 >= 0 && col + 2 < cLength) {
			if(paper[row][col] + paper[row][col+1] + paper[row-1][col+1] + paper[row-1][col+2] > max)
				max = paper[row][col] + paper[row][col+1] + paper[row-1][col+1] + paper[row-1][col+2];
		}
		
		if(row - 2 >= 0 && col + 1 <cLength) {
			if(paper[row][col] + paper[row-1][col] + paper[row-1][col+1] + paper[row-2][col+1] > max)
				max = paper[row][col] + paper[row-1][col] + paper[row-1][col+1] + paper[row-2][col+1];
		}
		
		if(row + 1 < rLength && col + 2 < cLength) {
			if(paper[row][col] + paper[row][col+1] + paper[row+1][col+1] + paper[row+1][col+2] > max)
				max = paper[row][col] + paper[row][col+1] + paper[row+1][col+1] + paper[row+1][col+2];
		}
		
		return max;
	}
	
	// ㅗ 모양 및 회전.
	public static int block5(int[][] paper, int row, int col) {
		int max = 0;
		
		if(col + 2 < cLength && row + 1 < rLength) {
			if(paper[row][col] + paper[row][col+1] + paper[row+1][col+1] + paper[row][col+2] > max)
				max = paper[row][col] + paper[row][col+1] + paper[row+1][col+1] + paper[row][col+2];
		}
		
		if(col + 1 < cLength && row - 1 >= 0 && row + 1 < rLength) {
			if(paper[row][col] + paper[row][col+1] + paper[row-1][col+1] + paper[row+1][col+1] > max)
				max = paper[row][col] + paper[row][col+1] + paper[row-1][col+1] + paper[row+1][col+1];
		}

		if(row - 1 >= 0 && col + 2 < cLength) {
			if(paper[row][col] + paper[row][col+1] + paper[row-1][col+1] + paper[row][col+2] > max)
				max = paper[row][col] + paper[row][col+1] + paper[row-1][col+1] + paper[row][col+2];
		}
		
		if(row - 1 >= 0 && row + 1 < rLength && col + 1 < cLength) {
			if(paper[row][col] + paper[row-1][col] + paper[row+1][col] + paper[row][col+1] > max)
				max = paper[row][col] + paper[row-1][col] + paper[row+1][col] + paper[row][col+1];
		}
		
		return max;
	}
}
