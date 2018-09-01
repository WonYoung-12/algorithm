import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Day3_Problem3 {
	static int n;
	static int x;
	static int y;
	static int[] visited;
	static boolean nextExisted = false;
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		visited = new int[n+1];
		x = scanner.nextInt();
		y = scanner.nextInt();
		
		// 못 찾으면 -1 출력을 위해 -1로 채운다.
		Arrays.fill(visited, -1);
		stack.push(x);
		visited[x] = 0;
//		stack.push(x);
		int[][] relation = {{1, 2}, {1, 3}, {2, 7}, {2, 8}, {2, 9}, {4, 5}, {4, 6}};	

		while(!stack.isEmpty()) {
			nextExisted = false;
			int temp = stack.pop(); 
			for(int row=0; row<relation.length; row++) {
				if( relation[row][1] == temp && visited[relation[row][0]] == -1){
					if(!nextExisted) {
						nextExisted = true;
						stack.push(temp);
					}
					visited[relation[row][0]] = visited[relation[row][1]] + 1;
					stack.push(relation[row][0]);
				}
				if(relation[row][0] == temp && visited[relation[row][1]] == -1){
					if(!nextExisted) {
						nextExisted = true;
						stack.push(temp);
					}
					visited[relation[row][1]] = visited[relation[row][0]] + 1;
					stack.push(relation[row][1]);
				}
			}
		}
		
		System.out.println(visited[y]);
	}
}
