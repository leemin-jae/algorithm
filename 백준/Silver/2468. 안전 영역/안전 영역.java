import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int delta[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        int Map[][] = new int[N][N];

        int max_h = Integer.MIN_VALUE;
        int min_h = Integer.MAX_VALUE;

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ;j++){
                Map[i][j] = Integer.parseInt(st.nextToken());
                if(max_h < Map[i][j]) max_h = Map[i][j];
                if(min_h > Map[i][j]) min_h = Map[i][j];
            }
        }

        int result = 0;

        for(int k = min_h-1; k < max_h ; k++){

            boolean visited[][] = new boolean[N][N];
            int sum = 0;
            for(int i = 0; i < N ;i++){
                for(int j = 0 ; j < N ;j++){

                    if(Map[i][j] > k && !visited[i][j]){
                        sum += bfs(i,j,Map, visited,k);
                    }

                }
            }

            result = Math.max(result, sum);

        }

        System.out.println(result);



    }

    private static int bfs(int i, int j, int[][] map, boolean[][] visited, int h) {

        Queue<int []> que = new LinkedList<>();
        que.add(new int[] {i,j});
        visited[i][j] = true;

        while (!que.isEmpty()){
            int now[] = que.poll();

            for(int k = 0; k < 4 ;k++){
                int nextX = now[0] + delta[k][0];
                int nextY = now[1] + delta[k][1];

                if(nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map.length) continue;
                if(map[nextX][nextY] <= h || visited[nextX][nextY]) continue;

                que.add(new int[] {nextX, nextY});
                visited[nextX][nextY] = true;
            }

        }

        return 1;
    }

}