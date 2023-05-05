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
        if(N%2 == 1) {
            System.out.println(0);
            return;
        }
        int Dp[] = new int[31];

        Dp[2] = 3;

        for(int i = 4; i <= N ;i+=2) {
            Dp[i] += Dp[i-2]*3;
            for(int j = 4 ; i - j > 0 ; j+=2){
                Dp[i] += Dp[i - j] * 2;
            }
            Dp[i] += 2;
        }

        System.out.println(Dp[N]);

    }

}