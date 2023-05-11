import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long Max, Min,  N , M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        int Max = (int)Math.sqrt(M);
        int len = (int)(M-N+1);

        boolean checked[] = new boolean[len];


        for(long i = 2 ; i <= Max ;i++ ){
            long squared = i*i;
            long start = N % squared== 0 ? N/squared : (N/squared) +1;
            for(long j = start; j*squared <= M ;j++){
                checked[(int)((j*squared) - N)] = true;
            }
        }
        int result = 0;
        for(int j = 0 ; j < len ; j++){
            if(!checked[j]) result++;
        }
        System.out.println(result);
    }


}