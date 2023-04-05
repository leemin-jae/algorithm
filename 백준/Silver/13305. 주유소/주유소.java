import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int count[], result;
    static boolean checked[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int line[] = new int[N-1];
        int money[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N-1 ; i ++){
            line[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            money[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, line, money));
    }

    public static  int solution(int n, int line[], int money[]) {

        int min = Integer.MAX_VALUE;
        int answer = 0;
        for(int i= 0 ; i < n-1 ;i++){
            min =  Math.min(money[i],min);
            answer += min * line[i];
        }

        return answer;
    }


}