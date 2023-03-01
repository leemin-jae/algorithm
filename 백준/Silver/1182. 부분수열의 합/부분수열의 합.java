import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int N, M, ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int Map[] = new int[N];
        for(int i = 0 ; i < N ;i++){
            Map[i] = Integer.parseInt(st.nextToken());
        }


        com(0,0,0,Map);

        System.out.println(ans);


    }
    static public void com(int cnt, int num,int sum, int[] map){
        if(cnt == N){
            if(sum == M && num > 0){
                ans++;
            }
            return;
        }

        com(cnt+1,num+1, sum+map[cnt] ,map);
        com(cnt+1, num,sum , map);




    }
}