import java.util.Scanner;
 
public class baekjoon_14503 {
    static int N;
    static int M;
    
    static int r;
    static int c;
    static int d;
    static int count;
    
    static boolean state = true;
    static int[][] map;
    
    private static void clean(int x, int y, int d){
        while ( state ){
            if ( map[x][y] == 0 ){ // 현재위치를 청소한다.
                count++;
                map[x][y] = 2; // 방문한 곳으로 상태 변경
            }
            
            if ( d == 0){
                if( y > 1 && map[x][y-1] == 0 ){
                    d = 3;
                    clean(x, y-1, 3);
                }
                else if ( x < N && map[x+1][y] == 0 ){
                    d = 2;
                    clean (x+1, y, 2);
                }
                else if ( y < M && map[x][y+1] == 0 ){
                    d = 1;
                    clean(x, y+1, 1);
                }
                else if ( x > 1 && map[x-1][y] == 0 ){
                    d = 0;
                    clean(x-1, y, 0);
                }
            }
            if( d == 1){
                if ( x > 1 && map[x-1][y] == 0 ){
                    d = 0;
                    clean(x-1, y, 0);
                }
                else if( y > 1 && map[x][y-1] == 0 ){
                    d = 3;
                    clean(x, y-1, 3);
                }
                else if ( x < N && map[x+1][y] == 0 ){
                    d = 2;
                    clean (x+1, y, 2);
                }
                else if ( y < M && map[x][y+1] == 0 ){
                    d = 1;
                    clean(x, y+1, 1);
                }
            }
            if ( d == 2) {
                if ( y < M && map[x][y+1] == 0 ){
                    d = 1;
                    clean(x, y+1, 1);
                }
                else if ( x > 1 && map[x-1][y] == 0 ){
                    d = 0;
                    clean(x-1, y, 0);
                }
                else if( y > 1 && map[x][y-1] == 0 ){
                    d = 3;
                    clean(x, y-1, 3);
                }
                else if ( x < N && map[x+1][y] == 0 ){
                    d = 2;
                    clean (x+1, y, 2);
                }
            }
            if ( d == 3){
                if ( x < N && map[x+1][y] == 0 ){
                    d = 2;
                    clean (x+1, y, 2);
                }
                else if ( y < M && map[x][y+1] == 0 ){
                    d = 1;
                    clean(x, y+1, 1);
                }
                else if ( x > 1 && map[x-1][y] == 0 ){
                    d = 0;
                    clean(x-1, y, 0);
                }
                else if( y > 1 && map[x][y-1] == 0 ){
                    d = 3;
                    clean(x, y-1, 3);
                }
            }
            
            if ( map[x-1][y] != 0 && map[x+1][y] != 0 && map[x][y-1] != 0 && map[x][y+1] != 0 ){ // 네 방향이 못가는 경우
                if ( d == 0 ) { 
                    if ( map[x+1][y] == 1 || x+1 > N ){ // 북 방향에서 후진이 안되는 경우
                        state = false;
                    }
                    else {
                        clean( x+1, y, d );
                    }
                }
                else if ( d == 1 ){
                    if ( map[x][y-1] == 1 || y-1 < 1 ){
                        state = false;
                    }
                    else{
                        clean(x, y-1, d);
                    }
                }
                else if ( d == 2 ){
                    if ( map[x-1][y] == 1 || x-1 < 1 ){
                        state = false;
                    }
                    else {
                        clean( x-1, y , d );
                    }
                }
                else {
                    if ( map[x][y+1] == 1 || y+1 > M ){ // 벽이라면
                        state = false;
                    }
                    else {
                        clean ( x, y+1, d);
                    }
                }
            }
        }
            
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        // (r,c) r-북쪽으로 떨어진 칸의 수, c-서쪽으로 떨어진 칸의 수
        // 현재 방향을 기준으로 왼쪽부터 탐색
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt(); // 0북 ,1동, 2남, 3서
        
        map = new int[N+2][M+2];
        for ( int i = 0; i <= N+1; i++ ){
            for ( int j = 0; j <= M+1; j++ ){
                if ( i == 0 || j == 0  || i == N+1 || j == M+1 ){
                    map[i][j] = 1; // 겉을 벽으로 둘러 싼다.
                }
                else{
                    map[i][j] = sc.nextInt(); // 빈칸은 0, 벽은 1
                }
            }
        }
        
        map[r+1][c+1] = 2;
        count = 1;
        
        clean(r+1, c+1, d);
        System.out.println(count);
        
    }    
    
}