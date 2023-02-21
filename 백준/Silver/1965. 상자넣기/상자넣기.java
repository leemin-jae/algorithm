import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static char Map[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Map[] = new int[N];

        for(int i =0 ; i < N ; i++){
            Map[i] = Integer.parseInt(st.nextToken());
        }

        int Dp[] = new int[N];

        Dp[0] = 1;
        int result = 1;

        for(int i = 0 ; i < N ;i++){
            Dp[i] = 1;
            for(int j = 0 ; j < i ; j++){
                if(Map[i] > Map[j]){
                    Dp[i] = Math.max(Dp[i], Dp[j] + 1);
                }
            }
            result = Math.max(result, Dp[i]);
        }

        System.out.println(result);


    }
}