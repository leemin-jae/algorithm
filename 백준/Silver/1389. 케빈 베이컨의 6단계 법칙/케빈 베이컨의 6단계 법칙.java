import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int relation[][] = new int [N+1][N+1];

        for(int  i = 0 ; i < M ;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            relation[from][to] = 1;
            relation[to][from] = 1;
        }
        int result = -1;
        int ans = Integer.MAX_VALUE;

        for(int k = 1 ; k <= N ;k++){

            int now[] = new int[N+1];
            boolean visited[] = new boolean[N+1];
            Arrays.fill(now, 123456789);
            now[k] = 0;

            for(int j = 0 ; j < N;j++) {
                int cnt = -1;
                int min = Integer.MAX_VALUE;
                for (int i = 1; i <= N; i++) {
                    if (min > now[i] && !visited[i]) {
                        cnt = i;
                        min = now[i];
                    }
                }

                visited[cnt] = true;
                for (int i = 1; i <= N; i++) {
                    if (relation[cnt][i] == 1) {
                        now[i] = Math.min(now[cnt] + 1, now[i]);
                    }
                }
            }
            int check = Arrays.stream(now).sum() - now[0];
            if(ans > check){
                result = k;
                ans = check;
            }
        }

        System.out.println(result);

    }

}