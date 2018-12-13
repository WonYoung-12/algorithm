import java.util.Scanner;
import java.util.Stack;

public class Problem1218 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int t=0; t<1; t++) {
			Stack<Character> stack = new Stack<Character>();
			boolean valid = false;
			int length = Integer.parseInt(scanner.nextLine());
			String line = scanner.nextLine();
			
			int position = 0;
			String open = "([{<";
			String close = ")]}>";
			
			// logic.
			while(true) {
				// 닫는 괄호일 때.
				if (open.indexOf(line.charAt(position)) == -1) {
					if(stack.isEmpty()) {
						break;
					}
					else {
						char ch = stack.peek();
						int index = close.indexOf(line.charAt(position));
						if(ch == open.charAt(index)){
							stack.pop();
						}
						else
							break;
					}
				}
				// 여는 괄호일 때.
				else {
					stack.push(line.charAt(position));
				}
				position++;
				if(position>=length) {
					if(stack.isEmpty()) {
						valid = true;
					}
					break;
				}
			}
			System.out.print("#" + (t+1) + " ");
			if(valid)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}
