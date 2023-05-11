import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int Max, Min,  N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());


        int Map[] = new int[N];

        int k = Integer.MAX_VALUE;
        for(int i = 0 ; i < N ; i ++){
            if(i == 0){
                Map[0] = Integer.parseInt(br.readLine());
            }else if (i == 1){
                Map[i] = Integer.parseInt(br.readLine());
                k = Map[i] - Map[0];
            }else{
                Map[i] = Integer.parseInt(br.readLine());
                if(Map[i] - Map[i-1] % k != 0){
                    int num = Map[i] - Map[i-1];
                    int div = k;
                    while (true){
                        if(num % div != 0){
                            int cnt = num;
                            num = div;
                            div = cnt % div;
                        }else{
                            k = div;
                            break;
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i < N ; i++) {
            result += (Map[i] - Map[i-1])/k - 1;
        }
        System.out.println(result);


    }


}