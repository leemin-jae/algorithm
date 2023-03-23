import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int adj[];
    static List<Integer> list[];
    static boolean check[];

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        check = new boolean[N+1];
        for(int i = 1  ; i <= N ; i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            print(i);
        }


    }

    static public void print(int now) {
        if(check[now]) return;

        for(int i = 0 ; i < list[now].size() ; i++){
            if(!check[list[now].get(i)]){
                print(list[now].get(i));
            }
        }

        check[now] = true;
        System.out.print(now + " ");

    }

}