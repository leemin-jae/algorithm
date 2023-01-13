import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long dp[][] = new long[21][N+1];
        int Map[] = new int[N];

        for(int i = 0 ; i < N ;i++){
            Map[i] = Integer.parseInt(st.nextToken());
        }

        dp[Map[0]][1] = 1;


        for(int i = 1 ; i < N ;i++){

            for(int j = 0 ; j <= 20 ; j++){

                if(dp[j][i] != 0){
                    if(j - Map[i] >= 0){
                        dp[j - Map[i]][i+1] += dp[j][i] ;
                    }
                    if(j + Map[i] <= 20){
                        dp[j + Map[i]][i+1] += dp[j][i] ;
                    }
                }

            }

        }



        System.out.println(dp[Map[N-1]][N-1]);


    }
}