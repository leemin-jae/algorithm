import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int Map[][] = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            for(int j = 0; j < M ; j++){
                Map[i][j] = s.charAt(j) - '0';
            }
        }
        if(N == 1 || M == 1){
            System.out.println(1);
            System.exit(0);
        }else{
            int min = Math.min(N,M);
            for(int k = min-1; k >= 0 ; k--){
                for(int i = 0 ; i < N-k ; i ++){
                    for(int j = 0 ; j < M-k ; j++){
                        int now = Map[i][j];
                        if(Map[i+k][j] - now == 0 && Map[i][j+k] - now == 0 && Map[i+k][j+k] - now == 0) {
                            System.out.println((k+1)*(k+1));
                            System.exit(0);
                        }
                    }
                }
            }
        }

    }
}