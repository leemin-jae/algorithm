import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());


        for(int T = 0 ; T < tc ; T++ ){
            int N = Integer.parseInt(br.readLine());
            int dp[][] = new int[N+4][4];
            if(N <= 4){
                System.out.println(N);
                continue;
            }
            dp[1][1] = 1;
            dp[2][1] = 1;
            dp[2][2] = 1;
            dp[3][1] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;

            for(int i = 4 ; i<= N ;i++){
                dp[i][1] = dp[i-1][1];
                dp[i][2] = dp[i-2][2] + dp[i-2][1] ;
                dp[i][3] = dp[i-3][3] + dp[i-3][2] + dp[i-3][1];
            }
            System.out.println(dp[N][3] + dp[N][2] + dp[N][1]);
        }

    }

}