import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int delta[][] = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}} , Map[][] , N, M, cnt;
    static boolean checked[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while (true) {
            st = new StringTokenizer(br.readLine());
            M= Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if(M == 0 && N == 0) break;
            cnt = 0;
            Map = new int[N][M];
            checked = new boolean[N][M];


            for(int i = 0 ; i < N ;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < M ; j++){
                    Map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0 ; i < N ;i++){
                for(int j = 0 ; j < M ;j++){
                    if(!checked[i][j] && Map[i][j] == 1){
                        cnt += bfs(i,j);
                    }
                }
            }

            System.out.println(cnt);

        }


    }
    static public int bfs(int x , int y){
        checked[x][y] = true;
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()){
            int []now = queue.poll();

            for(int i = 0 ; i< delta.length ; i++){
                int nextX = now[0] + delta[i][0];
                int nextY = now[1] + delta[i][1];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || checked[nextX][nextY] || Map[nextX][nextY] == 0) continue;
                queue.add(new int[]{nextX, nextY});
                checked[nextX][nextY] = true;
            }
        }

        return 1;


    }


}