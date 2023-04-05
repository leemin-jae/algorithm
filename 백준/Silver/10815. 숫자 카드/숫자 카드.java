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
        int line[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            line[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int money[] = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i ++){
            money[i] = Integer.parseInt(st.nextToken());
        }

        solution(N, line, M, money);
    }

    public static void solution(int n, int line[], int m, int money[]) {

        Set<Integer> set = new HashSet<>();
        for(int i= 0 ; i < n ;i++){
            set.add(line[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i= 0 ; i < m ;i++){
            if(set.contains(money[i])){
                sb.append("1 ");
            }else{
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }
}