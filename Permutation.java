import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Permutation{
	private static int n = 5;
	private static int r;
	private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
	private static int[] answer;

	public static void perm(ArrayList<Integer> arrayList, int depth) {
		if(r == depth) {
			System.out.println(Arrays.toString(answer));
			return;
		}
		for(int i=0; i<n-depth; i++) {
			answer[depth] = arrayList.remove(i);
			perm(arrayList, depth+1);
			arrayList.add(i, answer[depth]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("몇개 고를지 입력.");
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		
		r = scanner.nextInt();
		answer = new int[r];
		
		perm(arrayList, 0);
	}

}
