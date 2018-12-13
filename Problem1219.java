import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Problem1219 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0; i<10; i++) {
			Stack<Integer> stack = new Stack<Integer>();
			int[][] map = new int[100][100];
			int[] visited = new int[100];
			Arrays.fill(visited, 0);
			
			int t = scanner.nextInt();
			int n = scanner.nextInt();
			for(int j=0; j<n; j++) {
				int start = scanner.nextInt();
				int end = scanner.nextInt();
				map[start][end] = 1;
			}
			
			stack.push(0);
			
			// logic.
			while(!stack.isEmpty()) {
				int start = stack.pop();
				visited[start] = 1;
				for(int j=0; j<100; j++) {
					if(map[start][j]==1 && visited[j]==0) {
						int end = j;
						stack.push(start);
						stack.push(end);
//						System.out.println(end + "방문");
						break;
					}
				}
			}
			System.out.print("#" + (i+1) + " ");
			if(visited[99] == 1)
				System.out.println(1);
			else
				System.out.println(0);
		}
		
	}
}
