import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long DP[][] = new long[N+1][K+1];

        for(int i = 0; i <= N ; i ++){
            DP[i][1] = 1;
        }

        for(int i = 2 ; i <= K ; i++){

            for(int j = 0 ; j <= N ; j++){
                long now = 0;
                for(int m = 0; m <= j ;m++){
                    now += DP[j-m][i-1];
                }
                DP[j][i] = now % 1000000000;
            }
        }



        System.out.println(DP[N][K]);


    }
}