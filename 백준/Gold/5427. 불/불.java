import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int delta[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    static char Map[][];
    static boolean checked[][], checked_f[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());

        for(int T = 0 ; T <tc ; T++){
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            Map = new char[N][M];
            checked = new boolean[N][M];
            checked_f = new boolean[N][M];

            Queue<int [] > queue = new LinkedList<>();
            Queue<int [] > fire = new LinkedList<>();

            for(int i = 0 ; i < N ;i++){
                String s = br.readLine();
                for(int j = 0 ; j < M ; j++){
                    Map[i][j] = s.charAt(j);
                    if(Map[i][j] == '#'){
                        checked[i][j] = true;
                        checked_f[i][j] = true;
                    }
                    else if(Map[i][j] == '@'){
                        queue.add(new int[]{i, j, 0});
                        checked[i][j] = true;
                    }else if(Map[i][j] == '*'){
                        fire.add(new int[]{i, j});
                        checked_f[i][j] = true;
                    }
                }
            }

            int cnt = -1;

            while (!queue.isEmpty() && cnt == -1){
                int size = queue.size();
                for(int k = 0 ; k < size ; k++) {
                    int now[] = queue.poll();

                    if (now[0] == 0 || now[0] == N - 1 || now[1] == 0 || now[1] == M - 1) {
                        cnt = now[2] + 1;
                        break;
                    }
                    for (int i = 0; i < 4; i++) {
                        int nextX = now[0] + delta[i][0];
                        int nextY = now[1] + delta[i][1];

                        if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || checked_f[nextX][nextY] || checked[nextX][nextY])
                            continue;
                        queue.add(new int[]{nextX, nextY, now[2] + 1});
                        checked[nextX][nextY] = true;
                    }
                }


                int size_f = fire.size();

                for(int i = 0 ; i < size_f ; i++){
                    int now_f[] = fire.poll();

                    for(int j = 0 ; j < 4 ;j ++){
                        int nextX = now_f[0] + delta[j][0];
                        int nextY = now_f[1] + delta[j][1];
                        if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || checked_f[nextX][nextY]) continue;
                        checked_f[nextX][nextY] = true;
                        fire.add(new int[] {nextX, nextY});
                    }
                }


                Queue<int []> q = new LinkedList<>();
                for(int [] n : queue){
                    if(!checked_f[n[0]][n[1]]){
                        q.add(n);
                        if (n[0] == 0 || n[0] == N - 1 || n[1] == 0 || n[1] == M - 1) {
                            cnt = n[2]+1;
                            break;
                        }
                    }
                }

                queue = q;


            }

            System.out.println(cnt == -1 ? "IMPOSSIBLE" : cnt);



        }


    }

}