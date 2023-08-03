import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N , Min, Max, M , K;

    static int delta[][] = {{0,1},{0,-1},{1,0},{-1,0},{0,0}};

    static int Map[][];

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int DP[][] = new int[N][M];
        int Min = 0;
        for(int i = 0 ; i < N ;i++){
            if(Map[i][0] == 0){
                DP[i][0] = 1;
                Min = 1;
            }
        }
        for(int i = 0 ; i < M ;i++){
            if(Map[0][i] == 0){
                DP[0][i] = 1;
                Min = 1;
            }
        }


        for(int i = 1 ; i < N ; i++){
            for (int j = 1; j < M; j++) {
                if(Map[i][j] == 0){
                    DP[i][j] = Math.min(DP[i-1][j] , Math.min(DP[i][j-1] , DP[i-1][j-1])) + 1;
                    Min = Math.max(Min, DP[i][j]);
                }
            }
        }

        System.out.println(Min);
    }

}