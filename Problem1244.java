import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem1244 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = Integer.parseInt(scanner.nextLine());
		for(int i=0; i<t; i++) {
			boolean flag = false;
			String line = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			String num = "";
			int change = 0;
			num = st.nextToken();
			change = Integer.parseInt(st.nextToken());
			System.out.println("num : " + num);
			System.out.println("change : " + change);
			
			int[] array = new int[num.length()];
			for(int j=0; j<num.length(); j++) {
				array[j] = (int)(num.charAt(j) - '0');
			}
			for(int loop=0; loop<change; loop++) {
				int max = array[loop];
				int index = -1;
				for(int j=array.length-1-loop; j>=loop; j--) {
					if(array[j] > max) {
						flag = false;
						max = array[j];
						index = j;
					}
					else if(array[j] == max) {
						if(!flag) {
							flag = true;
							index = j;
						}
					}
				}
				int temp = array[loop];
				array[loop] = max;
				array[index] = temp;
			}
			System.out.println(Arrays.toString(array));
		}
	}
}
