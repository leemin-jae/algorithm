import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N , Min, Max, M , K, X , P;

    static int delta[][] = {{0,1},{0,-1},{1,0},{-1,0},{0,0}};

    static int Map[][];
    static boolean checked[];
    public static void main(String[] args) throws IOException {

       st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());

       Map = new int[N][M];

       boolean[][] visited_j = new boolean[N][M];
       boolean[][] visited_f = new boolean[N][M];

       Queue<int []> queue_j = new LinkedList<>();
       Queue<int []> queue_f = new LinkedList<>();

       for(int i = 0 ; i < N ; i++){
           String s = br.readLine();
           for(int j = 0 ; j < M ;j++){
               if(s.charAt(j) == '#'){
                   Map[i][j] = -1;
               }else if (s.charAt(j) == 'J'){
                    queue_j.add(new int[]{i, j, 0});
                    visited_j[i][j] = true;
               }else if (s.charAt(j)=='F'){
                    queue_f.add(new int[]{i, j});
                    visited_f[i][j] = true;
               }
           }
       }

       Queue<int[]> temp_f = new LinkedList<>();
       Queue<int[]> temp_j = new LinkedList<>();
       boolean flag = false;
       int result = 0;

       while (!queue_j.isEmpty()){

           while (!queue_f.isEmpty()){
               int []now_f = queue_f.poll();
               for(int i = 0 ; i < 4 ; i++){
                   int x = now_f[0] + delta[i][0];
                   int y = now_f[1] + delta[i][1];
                   if(x < 0 || x >= N || y < 0 || y >= M || Map[x][y] == -1 || visited_f[x][y]) continue;
                   temp_f.add(new int[]{x , y});
                   visited_f[x][y] = true;
               }
           }
           queue_f.addAll(temp_f);
           temp_f.clear();

           while (!queue_j.isEmpty()){
               int []now_j = queue_j.poll();

               if(now_j[0] == 0 || now_j[0] == N-1 || now_j[1] == 0 || now_j[1] == M-1 ){
                   result = now_j[2] + 1;
                   queue_j.clear();
                   temp_j.clear();
                   flag = true;
                   break;
               }
               for(int i = 0 ; i < 4 ; i++){
                   int x = now_j[0] + delta[i][0];
                   int y = now_j[1] + delta[i][1];
                   if(x < 0 || x >= N || y < 0 || y >= M || Map[x][y] == -1 || visited_f[x][y] || visited_j[x][y]) continue;
                   temp_j.add(new int[]{x , y, now_j[2] + 1});
                   visited_j[x][y] = true;
               }
           }
           queue_j.addAll(temp_j);
           temp_j.clear();
       }

        System.out.println(flag?result:"IMPOSSIBLE");
    }
}