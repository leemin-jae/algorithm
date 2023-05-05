import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int Map[] , c;
    static boolean checked[];
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        int Dp[] = new int[N+1];
        Arrays.fill(Dp , Integer.MAX_VALUE);

        for (int i = 1; i*i <= N; i++) {
            Dp[i*i] = 1;
        }

        for(int i = 2; i <= N ;i++) {

            for(int j = 1; i - j*j > 0 ; j++){
                Dp[i] = Math.min(Dp[i], Dp[i - j*j] + 1);
            }

        }

        System.out.println(Dp[N]);

    }
    // 1 4 9 16 25 1 2 3 1


}