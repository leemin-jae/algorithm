import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        int dp[][] =new int [N][N];
        int Map[][] = new int[N][N];

        for(int i = 0 ; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j <= i ; j++){
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = Map[0][0];

        for(int i = 0 ; i< N-1 ;i++){

            for(int j = 0 ; j <= i ; j ++){
                dp[i+1][j] = Math.max(Map[i+1][j] + dp[i][j],dp[i+1][j]);
                dp[i+1][j+1] = Math.max(Map[i+1][j+1] + dp[i][j],dp[i+1][j+1]);
            }
        }

        int Max = -1;

        for(int i = 0 ; i < N ;i++){
            Max = Math.max(Max, dp[N-1][i]);
        }
        System.out.println(Max);



    }
}