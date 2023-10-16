import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int to;
        int w;
        Node(int to, int w){
            this.to = to;
            this.w = w;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N , node , Max;
    static List<Node> list[];
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        list = new List[N+1];
        
        Max = Integer.MIN_VALUE;


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            list[start] = new ArrayList<>();
            
            while (st.hasMoreTokens()){
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) break;
                int w = Integer.parseInt(st.nextToken());
                list[start].add(new Node(to , w));
            }

        }
        boolean checked[] = new boolean[N+1];
        checked[1] = true;
        dfs(1, 0 , checked);

        checked = new boolean[N+1];
        checked[node] = true;
        dfs(node , 0 , checked);
        System.out.println(Max);



    }
    static public void dfs(int cnt , int num , boolean checked[]){
        if(Max < num){
            Max = num;
            node = cnt;
        }

        for (Node now : list[cnt]) {
            if(!checked[now.to]){
                checked[now.to] = true;
                dfs(now.to , num + now.w , checked);
                checked[now.to] = false;
            }
        }

    }

}