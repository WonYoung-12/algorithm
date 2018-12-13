import java.util.Arrays;

public class NoOvertime {
	public int noOvertime(int no, int[] works) {
		int result = 0;
		// 야근 지수를 최소화 하였을 때의 야근 지수는 몇일까요?
		while(no>0) {
			Arrays.sort(works);
			works[works.length-1]--;
			no--;
		}
		for(int i=0; i<works.length; i++) {
			result += works[i] * works[i];
		}
		return result;
	}
	public static void main(String[] args) {
		NoOvertime c = new NoOvertime();
		int []test = {4,3,3};
		System.out.println(c.noOvertime(4,test));
	}
}
