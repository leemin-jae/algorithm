import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int visited[] = new int[F+1];

        Arrays.fill(visited, -1);
        Queue<Integer> que = new LinkedList<>();
        visited[S] = 0;
        que.add(S);

        while(!que.isEmpty()){
            int now = que.poll();
            if(now == G) break;

            int up = now + U;
            int down = now -D;

            if(up <= F && up > 0 && visited[up] == -1){
                que.add(up);
                visited[up] = visited[now] + 1;
            }
            if(down <= F && down > 0 && visited[down] == -1){
                que.add(down);
                visited[down] = visited[now] + 1;
            }

        }

        System.out.println(visited[G] == -1?"use the stairs" : visited[G]);

    }

}