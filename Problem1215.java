import java.util.Scanner;

public class Problem1215 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[][] map = new char[8][8];
		
		for(int t=0; t<10; t++) {
			int answer = 0;
			int length = Integer.parseInt(scanner.nextLine());
			
			for(int row=0; row<8; row++) {
				String line = scanner.nextLine();
				for(int col=0; col<8; col++) {
					map[row][col] = line.charAt(col);
				}
			}
			int check=0;
			// logic.
			// 길이가 짝수.
			if(length%2==0) {
				for(int row=0; row<8; row++) {
					check = 0;
					for(int col=0; col<8; col++) {
						check = 0;
						//  가로 체크.
						for(int i=0; i<length/2 && col+length<9; i++) {
							if(map[row][col+i] == map[row][col+length-1-i]) {
								check++;
								if(check==length/2) {
									answer++;
									check=0;
								}
							}
							else break;
						}
						check=0;
						for(int i=0; i<length/2 && row+length<9; i++) {
							if(map[row+i][col] == map[row+length-1-i][col]) {
								check++;
								if(check==length/2) {
									answer++;
									check=0;
								}
							}
							else break;
						}
					}
				}
			}
			else {
				for(int row=0; row<8; row++) {
					check = 0;
					for(int col=0; col<8; col++) {
						check = 0;
						//  가로 체크.
						for(int i=0; i<length/2+1 && col+length<9; i++) {
							if(map[row][col+i] == map[row][col+length-1-i]) {
								check++;
								if(check==length/2+1) {
									answer++;
									check=0;
								}
							}
							else break;
						}
						check = 0;
						for(int i=0; i<length/2+1 && row+length<9; i++) {
							if(map[row+i][col] == map[row+length-1-i][col]) {
								check++;
								if(check==length/2+1) {
									answer++;
									check=0;
								}
							}
							else break;
						}
					}
				}
			}
			System.out.println("#" + (t+1) + " " + answer);
		}
	}
}
