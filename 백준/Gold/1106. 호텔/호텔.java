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

        int dp[] = new int[N+101];
        Arrays.fill(dp, 999999999);

        dp[0] = 0;

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());  // 비용
            int people = Integer.parseInt(st.nextToken());   // 사람 수

            for(int j = people ; j < N + 101; j++){
                dp[j] = Math.min(dp[j], cost + dp[j-people]);
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i= N ; i < N+101; i++){
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }
}