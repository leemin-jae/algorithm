import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int k_delta[][] = {{2,1},{1,2},{-1,-2},{-2,-1},{-1,2},{-2,1},{1,-2},{2,-1}},q_delta[][] = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
    static boolean checked[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int Map[][] = new int[N+1][M+1];

        String []save = new String[3];
        save[2] = br.readLine();
        save[1] = br.readLine();
        save[0] = br.readLine();

        for(int i = 0 ; i < 3 ; i++){
            st = new StringTokenizer(save[i]);
            if(st.nextToken().equals("0"))continue;

            while (st.hasMoreTokens()){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(i == 0){
                    Map[x][y] = 1;    
                }
                else if(i == 1){
                    Map[x][y] = 2;
                    for(int k = 0 ; k < k_delta.length ; k++){
                        int nextX = x + k_delta[k][0];
                        int nextY = y + k_delta[k][1];

                        if(nextX <= 0 || nextX > N || nextY <= 0 || nextY > M || Map[nextX][nextY] != 0) continue;
                        Map[nextX][nextY] = -1;
                    }
                }else{
                    Map[x][y] = 3;
                    for(int k = 0 ; k < q_delta.length ; k++){
                        int nextX = x + q_delta[k][0];
                        int nextY = y + q_delta[k][1];
                        while (true){
                            if(nextX <= 0 || nextX > N || nextY <= 0 || nextY > M || Map[nextX][nextY] >= 1) break;
                            Map[nextX][nextY] = -1;
                            nextY += q_delta[k][1];
                            nextX += q_delta[k][0];

                        }
                    }
                }
            }
        }

        int cnt = 0;
        for(int i = 1 ; i<= N ;i++){
            for(int j = 1 ; j <= M ;j++){
                if(Map[i][j] == 0){
                    cnt++;
                }
                //System.out.print(Map[i][j] + " ");
            }
            //System.out.println();
        }

        System.out.println(cnt);



    }

}