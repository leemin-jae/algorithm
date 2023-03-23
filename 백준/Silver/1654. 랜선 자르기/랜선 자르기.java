import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Map[] = new int[N];
        for(int i = 0 ; i< N ; i++){
            Map[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(Map);
        long left = 1;
        long right = Map[Map.length -1];

        while(left <= right){

            long mid = (left + right)/2;

            long num = 0;
            for(int i = 0 ; i < N ;i++){
                num += Map[i] / mid;
            }

            if(num < M){
                right = mid -1;
            }else{
                left = mid + 1;
            }

        }

        System.out.println(right);



    }

}