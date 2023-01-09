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

        int DP[][][] = new int [N][N][3];
        int Map[][] = new int [N][N];

        StringTokenizer st = null;

        for(int i = 0 ; i <  N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 0 == 가로 // 1 == 세로 // 2== 대각선
        for(int i = 0 ; i < N ;i++){
            if(Map[0][i] == 1) break;
            DP[0][i][0] = 1;
        }

        for(int i = 1 ; i < N ;i ++){
            for(int j = 2 ; j < N ;j ++){
                if(Map[i][j] == 1) continue;


                DP[i][j][0] = DP[i][j - 1][0] + DP[i][j - 1][2];


                DP[i][j][1] = DP[i - 1][j][1] + DP[i - 1][j][2];

                if(Map[i-1][j] != 1 && Map[i][j-1] != 1) {
                    DP[i][j][2] = DP[i - 1][j - 1][0] + DP[i - 1][j - 1][1] + DP[i - 1][j - 1][2];
                }


            }
        }


        System.out.println(DP[N-1][N-1][0] + DP[N-1][N-1][1] + DP[N-1][N-1][2]);
    }

}