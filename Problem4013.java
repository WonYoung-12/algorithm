import java.util.Arrays;
import java.util.Scanner;

public class Problem4013 {
	static int[] first = new int[8];
	static int[] second = new int[8];
	static int[] third = new int[8];
	static int[] fourth = new int[8];
	// 각 바퀴가 어디로 회전할 지 담는 배열.
	// 1이 시계, -1이 반시계 방향.
	static int[] dir = new int[4];
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int T = scanner.nextInt();
		for (int t = 0; t < T; t++) {
			int K = scanner.nextInt();

			setting(first);
			setting(second);
			setting(third);
			setting(fourth);

			for (int i = 0; i < K; i++) {
				int where = scanner.nextInt();
				// 1이 시계. -1이 반시계.
				int direction = scanner.nextInt();
				switch (where) {
				case 1:
					dir[0] += direction;
					// 자성이 다른 경우 회전
					if (first[2] != second[6]) {
						dir[1] += -direction;
						if (second[2] != third[6]) {
							dir[2] += direction;
							if (third[2] != fourth[6]) {
								dir[3] += -direction;
							}
						}
					}
					break;
				case 2:
					dir[1] += direction;
					if (first[2] != second[6])
						dir[0] += -direction;
					if (second[2] != third[6]) {
						dir[2] += -direction;
						if (third[2] != fourth[6]) {
							dir[3] += direction;
						}
					}

					break;
				case 3:
					dir[2] += direction;
					if (second[2] != third[6]) {
						dir[1] += -direction;
						if (second[6] != first[2]) {
							dir[0] += direction;
						}
					}
					if (third[2] != fourth[6])
						dir[3] += -direction;
					break;
				case 4:
					dir[3] += direction;
					if (fourth[6] != third[2]) {
						dir[2] += -direction;
						if (third[6] != second[2]) {
							dir[1] += direction;
							if (second[6] != first[2]) {
								dir[0] += -direction;
							}
						}
					}
					break;
				}
				first = rotate(first, dir[0]);
				second = rotate(second, dir[1]);
				third = rotate(third, dir[2]);
				fourth = rotate(fourth, dir[3]);
				Arrays.fill(dir, 0);
			}

			System.out.println("#" + (t+1) + " " + (first[0] + second[0] * 2 + third[0] * 4 + fourth[0] * 8));
		}
	}

	public static void setting(int[] array) {
		for (int i = 0; i < 8; i++)
			array[i] = scanner.nextInt();
	}

	public static int[] rotate(int[] array, int direction) {
		int[] temp = new int[8];
		// 시계방향.
		if (direction == 1) {
			for (int i = 0; i < 8; i++) {
				temp[i] = array[(i + 7) % 8];
			}
			return temp;
		}
		// 반시계방향.
		else if (direction == -1) {
			for (int i = 0; i < 8; i++) {
				temp[i] = array[(i + 1) % 8];
			}
			return temp;
		} else
			return array;
	}
}
