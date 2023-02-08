import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int Map[][];
    static int N, result, white;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Map = new int[N][N];
        for(int i = 0 ; i < N ;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ;j++){
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0,0,N);
        System.out.println(white);
        System.out.println(result);



    }

    static public void bfs(int x , int y , int len){

        int sum = 0;
        for(int i = x ; i < x + len ; i++){
            for(int j = y  ; j < y+ len ; j++){
                sum += Map[i][j];
            }
        }

        if(sum == len*len){
            result++;
        }else if(sum == 0){
            white++;
        }else{
            int next = len/2;
            bfs(x+next,y+next,len/2);
            bfs(x+next,y,len/2);
            bfs(x,y+next,len/2);
            bfs(x,y,len/2);
        }
    }
}