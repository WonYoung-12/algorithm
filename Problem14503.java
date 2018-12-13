import java.util.Scanner;

public class Problem14503 {

   static int N;
   static int M;
   // 0은 빈 칸, 1은 벽.
   static int[][] map;
   static int answer = 1;
   
   static int r;
   static int c;
   
   // 0이면 북, 1이면 동, 2이면 남, 3이면 서.
   static int d;
   // 4가 되면 후진.
   static int back = 0;
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner scanner = new Scanner(System.in);
      N = scanner.nextInt();
      M = scanner.nextInt();
      map = new int[N][M];
      
      r = scanner.nextInt();
      c = scanner.nextInt();
      d = scanner.nextInt();
      
      for(int row=0; row<N; row++) {
         for(int col=0; col<M; col++) {
            map[row][col] = scanner.nextInt();
         }
      }
      
      map[r][c]=2;
      
      visit();
      System.out.println(r);
      System.out.println(c);
      
      System.out.println(answer);
   }
   
   public static void visit() {
      while(true) {
         System.out.println("?");
         if(r==0 || c==0 || r==N-1 || c==M-1)
            break;
         // 후진.
         if(back == 4) {
            if(d == 0) {
               if(r+1<N) {
                  if(r+1<N && map[r+1][c]==1)
                     break;
                  r++;
               }
            }
            else if(d == 1) {
               if(c-1>=0) {
                  if(map[r][c-1]==1)
                     break;
                  c--;
               }
            }
            else if(d == 2) {
               if(r-1>=0) {
                  if(map[r-1][c]==1)
                     break;
                  r--;
               }
            }
            else if(d == 3) {
               if(c+1<M) {
                  if(map[r][c+1]==1)
                     break;
                  c++;
               }
            }
         }
         back = 0;
         while(true){
            if(back==4)
               break;
            if(d == 0) {
               if(c-1>=0 && map[r][c-1]==0) {
                  map[r][c-1] = 2;
                  answer++;
                  c--;
                  break;
               }
               d = 3;
               back++;
            }
            // 동.
            else if(d == 1) {
               if(r-1>=0 && map[r-1][c]==0) {
                  map[r-1][c] = 2;
                  answer++;
                  r--;
                  break;
               }
               d = 0;
               back++;
            }
            // 남.
            else if(d == 2) {
               if(c+1<M && map[r][c+1]==0) {
                  map[r][c+1] = 2;
                  answer++;
                  c++;
                  break;
               }
               d = 1;
               back++;
            }
            // 서.
            else if(d == 3) {
               if(r+1<N && map[r+1][c]==0) {
                  map[r+1][c] = 2;
                  answer++;
                  r++;
                  break;
               }
               d = 2;
               back++;
            }
         }
      }
   }

}