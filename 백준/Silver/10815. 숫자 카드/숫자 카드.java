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

        solution(N, line, money);
    }

    public static void solution(int n, int line[], int money[]) {

        Set<Integer> set = new HashSet<>();

        for(int i= 0 ; i < line.length ;i++){
            set.add(line[i]);
        }
        for(int i= 0 ; i < money.length ;i++){
            if(set.contains(money[i])){
                System.out.print("1 ");
            }else{
                System.out.print("0 ");
            }
        }

    }


}