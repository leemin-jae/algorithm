import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Map[] = new int[N];

        for(int i  = 0 ; i < N ;i++){
            Map[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(Map);

        int left = 0;
        int right = Map[N-1];

        while(left <= right){

            int mid = (left + right)/2;
            int cnt = 1;
            int k = 0;
            for(int i = 0 ; i< N ; i++){
                if(Map[i] - Map[k] >= mid){
                    k = i;
                    cnt++;
                }
            }

            if(cnt < C){
                right = mid-1;
            }else{
                left = mid+1;
            }


        }

        System.out.println(right);




    }

}