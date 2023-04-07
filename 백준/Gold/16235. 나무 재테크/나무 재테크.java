import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int delta[][] = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
    static int A[][], Map[][], N, M ,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        Map = new int[N][N];


        PriorityQueue<Integer> [][] queues = new PriorityQueue[N][N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                queues[i][j] = new PriorityQueue<>();
            }
            Arrays.fill(Map[i],5);
        }


        for(int i = 0 ; i < M ;i++){
            st = new StringTokenizer(br.readLine());
            queues[Integer.parseInt(st.nextToken()) -1][Integer.parseInt(st.nextToken()) - 1].add(Integer.parseInt(st.nextToken()));
        }

        for(int tc = 0 ; tc < K ; tc++){
            int addTree[][] = new int[N][N];
            // 봄
            for(int i = 0 ; i < N ;i++){
                for(int j = 0 ; j < N ;j++){
                    int ground = 0;
                    Queue<Integer> q = new LinkedList<>();

                    while (!queues[i][j].isEmpty()){
                        int now = queues[i][j].poll();
                        if(Map[i][j] >= now){
                            Map[i][j] -= now;
                            q.add(now+1);
                            if((now + 1) % 5 == 0){
                                addTree[i][j]++;
                            }
                        }else{
                            ground += now/2;   // 죽으면 양분이 된다
                        }
                    }

                    while (!q.isEmpty()){
                        queues[i][j].add(q.poll());
                    }
                    Map[i][j] += (ground + A[i][j]);  // 여름 + 겨울 양분
                }
            }

            //번식
            for(int i = 0 ; i < N ;i++) {
                for (int j = 0; j < N; j++) {
                    if(addTree[i][j] != 0){
                        for(int k = 0 ; k < delta.length ; k++){
                            int x = i + delta[k][0];
                            int y = j + delta[k][1];
                            if(x < 0 || x >= N || y < 0 || y >= N) continue;

                            for(int l = 0 ; l < addTree[i][j] ; l++){
                                queues[x][y].add(1);
                            }

                        }
                    }
                }
            }
        }

        int cnt = 0;
        for(int i = 0 ; i < N ;i++) {
            for (int j = 0; j < N; j++) {
                cnt += queues[i][j].size();
            }
        }


        System.out.println(cnt);
    }



}