import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int delta[][] = {{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}} , Map[][] , N, cnt , x, y, goal_x , goal_y;
    static boolean checked[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ;tc ++){
            N = Integer.parseInt(br.readLine());
            Map = new int[N][N];
            checked = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            goal_x = Integer.parseInt(st.nextToken());
            goal_y = Integer.parseInt(st.nextToken());

            bfs();

        }


    }
    static public void bfs(){
        checked[x][y] = true;
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {x, y , 0});

        while (!queue.isEmpty()){
            int []now = queue.poll();
            if(now[0] == goal_x && now[1] == goal_y){
                System.out.println(now[2]);
                return ;
            }

            for(int i = 0 ; i< delta.length ; i++){
                int nextX = now[0] + delta[i][0];
                int nextY = now[1] + delta[i][1];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || checked[nextX][nextY]) continue;
                queue.add(new int[]{nextX, nextY, now[2] + 1});
                checked[nextX][nextY] = true;
            }
        }


    }


}