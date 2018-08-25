import java.util.Arrays;
class Solution {
    static int[] answer = new int[7];
    static int[] myAnswer = new int[7];
    static int[] input = new int[9];
    static boolean isAnswer = false;
    public static void main(String[] args) {
    		int[] heights = {20, 7, 23, 19, 10, 15, 25, 8, 13};
		solution(heights);
	}
    public static int[] solution(int[] heights) {
    		input = Arrays.copyOf(heights, heights.length);
        search(0, 0, 0);
        System.out.println(Arrays.toString(myAnswer));
        return myAnswer;
    }
    
    public static void search(int start, int sum, int count) {
		if(isAnswer)
			return;
		if(sum > 100)
			return;
		if(count == 7 && sum == 100) {
			myAnswer = Arrays.copyOf(answer, 7);
			Arrays.sort(myAnswer);
			isAnswer = true;
			return;
		}
		if(count == 7 && sum != 100)
			return;
		
		for(int i=start; i<9; i++) {
			answer[count] = input[i];
			search(i + 1, sum + input[i], count + 1);
			answer[count] = 0;
		}
	}
}