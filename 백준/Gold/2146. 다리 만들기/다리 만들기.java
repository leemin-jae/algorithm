import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N , Min;
    static int Map[][] , land[][];
    static int delta[][] = {{0,1},{1,0},{-1,0},{0,-1}};


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        Map = new int[N][N];
        Min = Integer.MAX_VALUE;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ;j++){
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        land = new int[N][N];
        int cnt = 1;
        boolean checked[][] = new boolean[N][N];

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ;j++){
                if (Map[i][j] != 0 && !checked[i][j]){
                    bfs_land(i, j , checked, cnt);
                    cnt++;
                }
            }
        }

//        for(int i = 0 ; i < N ; i++){
//            for(int j = 0 ; j < N ;j++){
//                System.out.print(land[i][j] + " ");
//            }
//            System.out.println();
//        }
//



        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ;j++){
                if (land[i][j] != 0){
                    bfs(i, j , land[i][j]);
                }
            }
        }

        System.out.println(Min-1);

    }

    private static void bfs_land(int x, int y, boolean[][] checked, int cnt) {

        checked[x][y] = true;
        land[x][y] = cnt;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x ,y});

        while(!queue.isEmpty()){
            int []now = queue.poll();
            land[now[0]][now[1]] = cnt;

            for(int i = 0 ; i < 4 ;i++){
                int nextX = now[0] + delta[i][0];
                int nextY = now[1] + delta[i][1];

                if(nextY < 0 || nextY >= N || nextX < 0 || nextX >= N || Map[nextX][nextY] == 0 || checked[nextX][nextY]) continue;
                queue.add(new int[] {nextX, nextY});
                checked[nextX][nextY] = true;
            }
        }


    }

    static public void bfs(int x , int y, int cnt){

        boolean visited[][] = new boolean[N][N];
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x ,y ,0});

        while(!queue.isEmpty()){
            int []now = queue.poll();
            //System.out.println(now[0] + " " + now[1]);
            if(now[2] > Min){
                break;
            }

            for(int i = 0 ; i < 4 ;i++){
                int nextX = now[0] + delta[i][0];
                int nextY = now[1] + delta[i][1];

                if(nextY < 0 || nextY >= N || nextX < 0 || nextX >= N || land[nextX][nextY] == cnt || visited[nextX][nextY]) continue;

                if(land[nextX][nextY] != cnt && land[nextX][nextY] != 0){
                    if(Min  > now[2] + 1){
                        Min = now[2] + 1;
                        //System.out.println(x + " " +   y + " " + Min);
                    }
                }
                queue.add(new int[] {nextX, nextY , now[2] + 1});
                visited[nextX][nextY] =true;
            }



        }

    }
}