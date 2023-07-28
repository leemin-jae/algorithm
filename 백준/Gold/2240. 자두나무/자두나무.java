import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N , Min, Max, M , K;

    static int delta[][] = {{0,1},{0,-1},{1,0},{-1,0}};

    static int Map[];
    static int check[][];
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int Dp[][][] = new int[N][2][M + 1];

        if (Integer.parseInt(br.readLine()) == 1) {
            Dp[0][0][0] = 1;
        } else {
            Dp[0][1][1] = 1;       // 자두가 1번 위치에 있기 때문에 무조건 이동해야됨
        }

        for (int i = 1; i < N; i++) {


            int first = 0;
            int second = 0;
            if(Integer.parseInt(br.readLine()) == 1){
                first = 1;
            }else{
                second = 1;
            }
            for(int j = 0 ; j <= M ; j++){
                if(j == 0){                 // 그 자리에서 절대 이동 안할때 
                    Dp[i][0][j] = Dp[i-1][0][j] + first;
                    Dp[i][1][j] = Dp[i-1][1][j] + second;
                }else {                  
                    Dp[i][0][j] = Math.max(Dp[i - 1][1][j - 1] + first, Dp[i - 1][0][j] + first);    // 이동을 하거나  그자리에서 계속 있을 때 
                    Dp[i][1][j] = Math.max(Dp[i - 1][0][j - 1] + second, Dp[i - 1][1][j] + second);
                }
            }

        }
        int result = Integer.MIN_VALUE;
//        for(int i = 0 ; i <= M ; i++){
//            for(int j = 0 ; j < N ; j++){
//                System.out.print(Dp[j][0][i] + " ");
//            }
//            System.out.println();
//        }        System.out.println("-----------");
//
//        for(int i = 0 ; i <= M ; i++){
//            for(int j = 0 ; j < N ; j++){
//                System.out.print(Dp[j][1][i] + " ");
//            }
//            System.out.println();
//        }

        for(int i = 0 ; i <= M ; i++){
//            System.out.println(Dp[N-1][0][i] + " "  + Dp[N-1][1][i]);
            result = Math.max(Dp[N-1][0][i] , result);
            result = Math.max(Dp[N-1][1][i] , result);
        }

        System.out.println(result);

    }

}