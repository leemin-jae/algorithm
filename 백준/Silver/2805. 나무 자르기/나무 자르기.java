import org.w3c.dom.Node;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Map[] = new int[N];

        for(int i = 0 ; i< N ; i++){
            Map[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Map);

        long left = 0;
        long right = Map[Map.length-1];

        while (left <= right){

            long mid = (left+right)/2;
            long num = 0;
            for(int i = 0 ; i <  N ;i++){
                num += Map[i] - mid < 0 ? 0 : Map[i] - mid;
            }

            if(num < M){
                right = mid - 1;
            }else{
                left = mid + 1;
            }




        }

        System.out.println(right);

    }

}