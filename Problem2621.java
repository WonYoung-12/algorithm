import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem2621 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringTokenizer st;
		String[] color = new String[5];
		int[] number = new int[5];
		
		int answer = 0;
		
		for(int i=0; i<5; i++) {
			String line = scanner.nextLine();
			st = new StringTokenizer(line, " ");
			color[i] = st.nextToken();
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(color);
		Arrays.sort(number);
		
		// 5장 모두 같은색. rule 1 or 4.
		if(color[0].equals(color[4])) {
			// rule 1.
			if(number[0] + 4 == number[4]) {
				if(number[4] + 900 > answer)
					answer = number[4] + 900;
			}
			// rule 4.
			else {
				if(number[4] + 600 > answer)
					answer = number[4] + 600;
			}
		}
		// rule 2.
		if( (number[0] == number[3] && number[3] != number[4]) || (number[1] == number[4] && number[0] != number[1])) {
			if(number[2] + 800 > answer)
				answer = number[2] + 800;
		}
		// rule 5.
		if(number[0] + 4 == number[4]) {
			if(number[0] + 500 > answer)
				answer = number[4] + 500;
		}
		// rule 3. 2/3
		if(number[0] == number[1] && number[1] != number[2] && number[2] == number[3] && number[3] == number[4]) {
			if(number[2] * 10 + number[0] + 700 > answer)
				answer = number[2] * 10 + number[0] + 700;
		}
		// rule 3. 3/2
		else if(number[0] == number[1] && number[1] == number[2] && number[2] != number[3] && number[3] == number[4]) {
			if(number[0] * 10 + number[3] + 700 > answer)
				answer = number[0] * 10 + number[3] + 700;
		}
		
		// rule 6.
		if(number[0] == number[2]) {
			if(number[0] + 400 > answer)
				answer = number[0] + 400;
		}
		else if(number[1] == number[3]) {
			if(number[1] + 400 > answer)
				answer = number[1] + 400;
		}
		else if(number[2] == number[4]) {
			if(number[2] + 400 > answer)
				answer = number[2] + 400;
		}
		
		// rule 7. 1/2/2
		if(number[0] != number[1] && number[1] == number[2] && number[2] != number[3] && number[3] == number[4]) {
			if(number[3] * 10 + number[1] + 300 > answer)
				answer = number[3] * 10 + number[1] + 300;
		}
		// rule 7. 2/1/2
		else if(number[0] == number[1] && number[1] != number[2] && number[2] != number[3] && number[3] == number[4]) {
			if(number[3] * 10 + number[0] + 300 > answer)
				answer = number[3] * 10 + number[0] + 300;
		}
		// rule 7. 2/2/1
		else if(number[0] == number[1] && number[1] != number[2] && number[2] == number[3] && number[3] != number[4]) {
			if(number[3] * 10 + number[0] + 300 > answer)
				answer = number[3] * 10 + number[0] + 300;
		}
		
		// rule 8. 2/1/1/1.
		if(number[0] == number[1] && number[1] != number[2]) {
			if(number[0] + 200 > answer)
				answer = number[0] + 200;
		}
		// rule 8. 1/2/1/1
		if(number[0] != number[1] && number[1] == number[2] && number[2] != number[3]) {
			if(number[1] + 200 > answer)
				answer = number[1] + 200;
		}
		// rule 8. 1/1/2/1
		if(number[0] != number[1] && number[1] != number[2] && number[2] == number[3] && number[3] != number[4])
			if(number[2] + 200 > answer)
				answer = number[2] + 200;
		if(number[2] != number[3] && number[3] == number[4])
			if(number[3] + 200 > answer)
				answer = number[3] + 200;
		
		// no rule.
		if(answer == 0)
			answer = number[4] + 100;
		
		System.out.println(answer);
	}
}
