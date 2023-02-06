import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int delta[][] = {{0,1},{1,0},{-1,0},{0,-1}}, Map[][];
    static int N, M;
    static boolean checked[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map = new int[N][M];
        checked = new boolean[N][M];

        int total = 0;

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++){

                Map[i][j] = Integer.parseInt(st.nextToken());
                total += Map[i][j];

                if(Map[i][j] == 0) checked[i][j] = true;

            }
        }

        int result = 0;
        while(true){

            int num = 0;
            boolean[][] visited = new boolean[N][M];
            for(int i = 1 ; i < N-1 ;i++){
                for(int j = 1 ; j < M-1 ; j++){
                    if(!checked[i][j]){
                        if(Map[i][j] == 0){
                            checked[i][j] = true;
                            continue;
                        }
                        if(visited[i][j]) continue;

                        num += bfs(i,j,visited);
                    }
                }
            }

            if(total == 0){
                System.out.println(0);
                break;
            }
            if(num >=  2){
                System.out.println(result);
                break;
            }

            for(int i = 1 ; i < N-1 ;i++){
                for(int j = 1 ; j < M-1 ; j++){
                    if(!checked[i][j]){
                        int sum = 0;
                        if(checked[i-1][j]) sum++;
                        if(checked[i][j-1]) sum++;
                        if(checked[i+1][j]) sum++;
                        if(checked[i][j+1]) sum++;

                        int minus = Map[i][j] > sum ? sum : Map[i][j];

                        Map[i][j] -= minus;
                        total -= minus;
                    }
                }
            }

            result++;


        }

    }

    static public int bfs(int x, int y , boolean visited[][]){

        Queue<int [] > que = new LinkedList<>();
        que.add(new int[] {x,y});
        visited[x][y] = true;

        while(!que.isEmpty()){

            int now[] = que.poll();

            for(int i = 0 ; i < 4 ;i++){
                int nextX = now[0] + delta[i][0];
                int nextY = now[1] + delta[i][1];

                if(Map[nextX][nextY] == 0 || visited[nextX][nextY]) continue;
                que.add(new int[] { nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }

        return 1;
    }
}