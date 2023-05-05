import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M , min , Map[][], delta[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    static int Hx, Hy , Ex, Ey , cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        Hx = Integer.parseInt(st.nextToken())-1;
        Hy = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        Ex = Integer.parseInt(st.nextToken())-1;
        Ey = Integer.parseInt(st.nextToken())-1;

        min = 987654321;
        cnt = 0;

        for(int i = 0 ; i < N ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j  < M ;j++){
                Map[i][j] = Integer.parseInt(st.nextToken());
                if(Map[i][j] == 1){
                    cnt++;
                }
            }
        }

        bfs();

        System.out.println(min == 987654321?-1 : min);

    }
    static void bfs(){
        Queue<int []> queue = new LinkedList<>();
        boolean [][][]checked = new boolean[N][M][2];

        queue.add(new int[] {Hx, Hy , 0 , 0});
        checked[Hx][Hy][0] = true;
        checked[Hx][Hy][1] = true;


        while (!queue.isEmpty()){

            int [] now = queue.poll();
            if(now[0] == Ex && now[1] == Ey){
                min = Math.min(min, now[2]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + delta[i][0];
                int nextY = now[1] + delta[i][1];

                if(nextX < 0 || nextY < 0 || nextY >= M || nextX >= N || checked[nextX][nextY][now[3]]) continue;

                if(Map[nextX][nextY] == 1){
                    if(now[3] == 0) {
                        queue.add(new int[]{nextX, nextY, now[2] + 1, 1});
                        checked[nextX][nextY][1] = true;
                    }
                }else{
                    queue.add(new int[] {nextX , nextY , now[2] + 1 , now[3]});
                    checked[nextX][nextY][now[3]] = true;
                }


            }

        }



    }
}