import java.util.Arrays;
import java.util.Scanner;

public class Day4_kakao4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 버스 운행 횟수.
		int n = scanner.nextInt();
		// 버스 간격 분 단위.
		int t = scanner.nextInt();
		// 버스당 탑승 인원.
		int m = scanner.nextInt();
		
		String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
		
		solution(n, t, m, timetable);
	}
	
	public static String solution(int n, int t, int m, String[] timetable) {
		Arrays.sort(timetable);
		String answer = "";
		
		int startHour = 9;
		int startMinute = 0;
		
		// 버스에 탑승한 승객들 카운트.
//		int count = 0;
		int[] busCount = new int[n];
		Arrays.fill(busCount, 0);
		String[] busTime = new String[n];
	
		
		return "";
	}
}
