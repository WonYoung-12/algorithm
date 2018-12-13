import java.util.ArrayList;
import java.util.Collections;

public class NextBigNumber {
	public int nextBigNumber(int n) {
		int answer = 0;
		// 1의 갯수.
		int count = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (true) {
			if (n % 2 == 1)
				count++;
			list.add(n % 2);
			n = n / 2;
			if (n == 0)
				break;
		}
		Collections.reverse(list);

		// logic
		int changeIndex = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) == 0 && list.get(i + 1) == 1)
				changeIndex = i;
		}
		for (int i = changeIndex; i < list.size(); i++) {
			if (i == changeIndex)
				list.set(i, 1);
			else
				list.set(i, 0);
		}
		for (int i = 0; i < list.size(); i++)
			if (list.get(i) == 1)
				count--;
		for (int i = list.size() - 1; i >= 0; i--) {
			if (count == 0)
				break;
			list.set(i, 1);
			count--;
		}
		for (int i = 0; i < list.size(); i++) {
			answer += list.get(i) * Math.pow(2, list.size() - 1 - i);
		}
		return answer;
	}

	public static void main(String[] args) {
		NextBigNumber test = new NextBigNumber();
		int n = 78;
		System.out.println(test.nextBigNumber(n));
	}
}