import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M,total, result;
    static boolean Map[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        Map = new boolean[10];
        int check = N;
        int cnt = 0;
        while(check != 0){
            cnt++;
            check = check/10;
        }

        total = cnt;
        if(M != 0) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                Map[Integer.parseInt(st.nextToken())] = true;
            }
        }

//        for(int i = 0 ; i < M ; i++){
//            Map[i] = Integer.parseInt(st.nextToken());
//        }

        result = Math.abs(100 - N);

        find(0,0);

        System.out.println(result);

    }

    static public void find(int k, int num){ // k는 자리수
        if(k == total + 1){
            return;
        }

        for(int i = 0 ; i< 10 ;i++){
            if(!Map[i]){
                int now = num + i * (int) Math.pow(10 , k);
                //System.out.println(now);
                result = result > Math.abs(N - now) + (k+1) ? Math.abs(N - now) + (k+1) : result;
                find(k+1 , now);
            }

        }

    }
}