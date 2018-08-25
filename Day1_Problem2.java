import java.util.ArrayList;
import java.util.Arrays;

public class Day1_Problem2 {
	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
		int[] answer;
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(arr[0]);
		
		for(int i=1; i<arr.length; i++) {
			int end = arrayList.get(arrayList.size()-1);
			// 같은 숫자아니면.
			if(end != arr[i]) {
				arrayList.add(arr[i]);
			}
		}
		
		answer = new int[arrayList.size()];
		for(int i=0; i<arrayList.size(); i++)
			answer[i] = arrayList.get(i);
		System.out.println(Arrays.toString(answer));
	}
}
