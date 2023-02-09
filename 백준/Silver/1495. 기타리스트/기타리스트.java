import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int S = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());

        int dp[] = new int[M+1];
        int v[] = new int[N+1];

        Arrays.fill(dp , -1);

        dp[S] = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= N ;i++){
            v[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=N; i++){ 
            list.clear();
            for(int j=0; j<=M; j++) { 
                if(dp[j] == i-1) { 
                    if (0 <= j - v[i] && j - v[i] <= M) { 
                        list.add(j - v[i]);
                    }
                    if (0 <= j + v[i] && j + v[i] <= M) {
                        list.add(j + v[i]);
                    }
                }
            }
            for (int k : list) {
                dp[k] = i;
            }
        }

        for(int i=M; i>=0; i--){
            if(dp[i] == N){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);

    }

}