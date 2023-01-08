import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        BFS(N,K);


    }
    static public void BFS(int N, int K){
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[300002];
        Arrays.fill(visited, Integer.MAX_VALUE);
        queue.add(N);
        visited[N] = 0;

        while(!queue.isEmpty()){
            int now = queue.poll();

            if(now <= K && visited[2*now] > visited[now]){
                queue.add(2*now);
                visited[2*now] = visited[now];
            }

            if(now + 1 <= K && visited[now + 1] > visited[now] + 1 ){
                queue.add(now+1);
                visited[now + 1] = visited[now] + 1;
            }

            if(now - 1 >= 0 && visited[now - 1] > visited[now] + 1 ){
                queue.add(now - 1);
                visited[now - 1] = visited[now] + 1;
            }

        }

        System.out.println(visited[K]);
    }
}