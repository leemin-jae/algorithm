import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N , Min, Max, M;

    static int delta[][] = {{0,1},{0,-1},{1,0},{-1,0}};

    static int Map[][];
    static int visited[][][];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map = new int[N][M];
        visited = new int[N][M][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
                for(int k = 0 ; k < 4 ;k++){
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start_N = Integer.parseInt(st.nextToken())-1;
        int start_M = Integer.parseInt(st.nextToken())-1;
        int start_dir = Integer.parseInt(st.nextToken())-1;


        st = new StringTokenizer(br.readLine());
        int end_N = Integer.parseInt(st.nextToken())-1;
        int end_M = Integer.parseInt(st.nextToken())-1;
        int end_dir = Integer.parseInt(st.nextToken())-1;

        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{start_N , start_M , start_dir,0});

        visited[start_N][start_M][start_dir] = 0;

        while (!queue.isEmpty()){

            int[] now = queue.poll();

            int x = now[0];
            int y = now[1];
            int dir = now[2];

//            if(now[3] == 4){
//                System.out.println(x + " " +y + " " +dir +" " + now[3]);
//            }

           if(now[3] > visited[x][y][dir]){
               continue;
           }


            // 그 방향대로 전진
            int nextX = x;
            int nextY = y;
            for(int i = 0 ; i < 3; i++){
                nextX += delta[dir][0];
                nextY += delta[dir][1];
                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && Map[nextX][nextY] != 1){
                    if(visited[nextX][nextY][dir] > now[3] + 1) {
                        queue.add(new int[]{nextX, nextY, dir, now[3] + 1});
                        visited[nextX][nextY][dir] = now[3] + 1;
                    }
                }else{
                    break;
                }
            }




            // 방향 전한

            int nextDir = dir;
            int nextDir2 = dir;
            if(dir == 0 || dir == 1){
                nextDir = 2;
                nextDir2 = 3;
            }else{
                nextDir = 0;
                nextDir2 = 1;
            }

            if(visited[x][y][nextDir] > now[3] + 1){
                queue.add(new int[]{x, y , nextDir , now[3]+1});
                visited[x][y][nextDir] = now[3] + 1;
            }

            if(visited[x][y][nextDir2] > now[3] + 1){
                queue.add(new int[]{x, y , nextDir2 , now[3]+1});
                visited[x][y][nextDir2] = now[3] + 1;
            }
        }



        System.out.println(visited[end_N][end_M][end_dir]);

//        for(int k = 0 ; k < 4 ;k++) {
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(visited[i][j][k] == Integer.MAX_VALUE?(-1 + " " ): (visited[i][j][k] + " "));
//                }
//                System.out.println();
//            }
//            System.out.println("-----------------");
//        }


    }

}