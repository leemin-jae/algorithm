import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int dp[] = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());  // 비용
            int second = Integer.parseInt(st.nextToken());   // 사람 수

            int cnt = 0;
            int price = second;
            int people = first;
            while(true){
                cnt++;
                price = second * cnt;
                people = first * cnt;
                for(int j = 1 ; j <= price && j <= N ; j++){
                    dp[j] = Math.min(dp[j], people);
                    //System.out.println(Arrays.toString(dp));
                }
                if(price > N){
                    break;
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        for(int i = 2; i <= N; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1 ; j <= i-j ; j++){
                if(dp[j] != Integer.MAX_VALUE && dp[i-j] != Integer.MAX_VALUE){
                    min = Math.min(min, dp[j] + dp[i - j]);
                }
            }

            dp[i] = Math.min(dp[i],min);

        }

        System.out.println(dp[N]);


    }
}