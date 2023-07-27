import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N , Min, Max, M , K;

    static int delta[][] = {{0,1},{0,-1},{1,0},{-1,0}};

    static int Map[][];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Map = new int[N][M];
        boolean visited[][][] = new boolean[N][M][K+1];

        for(int i = 0 ; i < N;i++){
            String s = br.readLine();
            for(int j= 0 ; j < M ; j++){
                Map[i][j] = s.charAt(j) - '0';
            }
        }

        visited[0][0][0] = true;
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {0,0,0,1});
        int result = -1;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] == N-1 && now[1] == M-1){
                result = now[3];
                break;
            }
            for (int i = 0 ; i < 4 ; i++){
                int nextX = now[0] + delta[i][0];
                int nextY = now[1] + delta[i][1];

                if(nextX < 0 || nextX >= N || nextY <0 || nextY >= M) continue;
                if(Map[nextX][nextY] == 1){
                    if(now[2] < K &&  !visited[nextX][nextY][now[2]+1]){
                        queue.add(new int[] {nextX, nextY , now[2]+1 , now[3]+1});
                        visited[nextX][nextY][now[2]+1] = true;
                    }
                }else{
                    if(!visited[nextX][nextY][now[2]]){
                        queue.add(new int[] {nextX, nextY , now[2] , now[3]+1});
                        visited[nextX][nextY][now[2]] = true;
                    }
                }
            }
        }

        System.out.println(result);

    }

}