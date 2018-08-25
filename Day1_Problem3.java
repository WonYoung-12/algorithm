
public class Day1_Problem3 {
	public static void main(String[] args) {
		String bowls = "()()";
		int answer = 10;

		for (int i = 0; i < bowls.length() - 1; i++) {
			// 같은 방향.
			if (bowls.charAt(i) == bowls.charAt(i + 1))
				answer += 5;
			// 다른 방향.
			else 
				answer += 10;
		}
		System.out.println(answer);
	}
}
