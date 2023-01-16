import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int parent = Integer.parseInt(st.nextToken());
        int child = Integer.parseInt(st.nextToken());
        int M =Integer.parseInt(br.readLine());

        List<Integer> nodes[] = new ArrayList[N+1];

        for(int i= 0 ; i< N+1 ; i++){
            nodes[i] = new ArrayList<>();

        }
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            nodes[from].add(to);
            nodes[to].add(from);
        }

        int dist [] = new int[N+1];
        boolean visited[] = new boolean[N+1];
        Arrays.fill(dist,987654321);

        Queue<Integer> que = new LinkedList<>();
        que.add(parent);
        dist[parent] = 0;
        visited[parent] = true;

        while (!que.isEmpty()){
            int now = que.poll();
            if(now == child){;
                break;
            }
            for(int ch : nodes[now]){
                if(!visited[ch]){
                    que.add(ch);
                    dist[ch] = dist[now]+1;
                    visited[ch] = true;
                }
            }
        }

        System.out.println(dist[child] == 987654321 ? -1 : dist[child]);


    }



}