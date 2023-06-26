import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int Map[][] = new int[N][M];
        int dp[][] = new int[N][M];
        int max = -1;
        for(int i = 0; i < N ; i++){
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                Map[i][j] = input.charAt(j) - '0';
                if(i == 0 || j == 0){
                    dp[i][j] = Map[i][j];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }


        for (int i = 1; i < N; i++) {
            for(int j = 1 ;  j < M; j++){
                if(Map[i][j] == 1){
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j] ,dp[i-1][j-1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        System.out.println(max * max);
    }



}