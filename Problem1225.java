import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1225 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>(); 
		
		for(int t=0; t<10; t++) {
			int T = scanner.nextInt();
			int cycle = 1;
			for(int i=0; i<8; i++) {
				queue.add(scanner.nextInt());	
			}
			
			while(true) {
				int remove = queue.poll() - cycle;
				if(remove <= 0) {
					remove = 0;
					queue.add(remove);
					break;
				}
				queue.add(remove);
				cycle++;
				if(cycle > 5)
					cycle = 1;
			}
			System.out.print("#" +  T + " ");
			for(int i=0; i<8; i++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
			queue.clear();
		}
	}
}
