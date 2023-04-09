import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int delta[][] =  {{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1}} ;
    static double w[] = {0,0.01,0.07,0.1,0.55,0.1,0.07,0.01} , w2[] = {0.02, 0.05,0.02};

    static int A[][], Map[][], N, M ,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        Map = new int[N][N];


        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ;j++){
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = N/2 , y = N/2;
        int cnt = 0;
        int len = 1;
        int now_len = 1;
        int direction = 0;

        int result = 0;

        while(!(x==0 && y ==0)){

            x += delta[direction][0];
            y += delta[direction][1];

            int reverse = (direction+ 4) % 8;
            int second = 0;
            int now = Map[x][y];
            for(int i =  1 ; i <  8 ; i++){
                int k = (reverse + i) % 8;
                int windX = (x + delta[k][0]);
                int windY = (y + delta[k][1]);

                int dust = (int)Math.floor(w[i] * Map[x][y]);

                if(k != direction) {
                    if (windX < 0 || windX >= N || windY < 0 || windY >= N) {
                        result += dust;
                    } else {
                        Map[windX][windY] += dust;
                    }

                    now -= dust;
                }


                if(k%2 == 0){
                    windX += delta[k][0];
                    windY += delta[k][1];

                    dust =  (int)Math.floor(w2[second] * Map[x][y]);
                    second++;
                    if(windX < 0 || windX >= N || windY < 0 || windY >= N){
                        result += dust;
                    }else{
                        Map[windX][windY] += dust;
                    }

                    now -= dust;
                }
            }

            int ax = x + delta[direction][0];
            int ay = y + delta[direction][1];

            if(ax < 0 || ax >= N || ay < 0 || ay >= N){
                result += now;
            }else{
                Map[ax][ay] += now;
            }

            Map[x][y] = 0;

            now_len--;


            if(now_len == 0){
                direction = (direction+2)%8;
                cnt++;
                if(cnt%2 == 0){
                    len++;
                }
                now_len = len;
            }
//            for(int i = 0 ; i < N ;i++){
//                for(int j = 0 ; j < N ;j++){
//
//                    System.out.print(Map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("================");
        }

        System.out.println(result);

    }



}