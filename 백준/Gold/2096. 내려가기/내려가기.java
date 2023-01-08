import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int DP[][][] = new int [2][N][3];
        int Map[][] = new int [N][3];

        StringTokenizer st = null;

        for(int i = 0 ; i <  N ; i++){
            st = new StringTokenizer(br.readLine());
            Map[i][0] = Integer.parseInt(st.nextToken());
            Map[i][1] = Integer.parseInt(st.nextToken());
            Map[i][2] = Integer.parseInt(st.nextToken());
        }

        DP[0][0][0] = Map[0][0];
        DP[0][0][1] = Map[0][1];
        DP[0][0][2] = Map[0][2];


        DP[1][0][0] = Map[0][0];
        DP[1][0][1] = Map[0][1];
        DP[1][0][2] = Map[0][2];


        for(int i = 1; i < N ; i++){

            DP[0][i][0] = Map[i][0] + Math.max(DP[0][i-1][0] , DP[0][i-1][1]);
            DP[0][i][1] = Map[i][1] + Math.max(Math.max(DP[0][i-1][0] , DP[0][i-1][1]),DP[0][i-1][2]);
            DP[0][i][2] = Map[i][2] + Math.max(DP[0][i-1][1] , DP[0][i-1][2]);


            DP[1][i][0] = Map[i][0] + Math.min(DP[1][i-1][0] , DP[1][i-1][1]);
            DP[1][i][1] = Map[i][1] + Math.min(Math.min(DP[1][i-1][0] , DP[1][i-1][1]),DP[1][i-1][2]);
            DP[1][i][2] = Map[i][2] + Math.min(DP[1][i-1][1] , DP[1][i-1][2]);

        }

        int Max = Math.max(Math.max(DP[0][N-1][0] , DP[0][N-1][1]),DP[0][N-1][2]);
        int Min =  Math.min(Math.min(DP[1][N-1][0] , DP[1][N-1][1]),DP[1][N-1][2]);

        System.out.println(Max + " " + Min);
    }

}