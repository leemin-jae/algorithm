import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int  N , M ;
    static String Map[];

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new String[N];


        int max = 0;
        for (int i = 0; i < N; i++) {
            Map[i] = br.readLine();
            max = Math.max(max, Integer.parseInt(Map[i]));
        }

        Arrays.sort(Map, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        String result = "";
        boolean flag = false;

        for (String s : Map){
            result += s;
            if(Integer.parseInt(s) == max && !flag){
                for(int i = 0 ;i < M- N ;i++){
                    result += s;
                }
                flag = true;
            }
        }

        System.out.println(result);



    }



}