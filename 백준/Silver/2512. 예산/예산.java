import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int Map[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int limit = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ;i++){
            Map[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Map);

        int left = 0;
        int right = Map[Map.length-1];

        while(left <= right){
            int mid = (left + right) / 2;

            long sum = 0;
            for(int i = 0 ; i < N ; i++){
                sum += Math.min(Map[i], mid);
            }

            if(sum <= limit){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }


        bw.write(String.valueOf(right));




        bw.flush();
        bw.close();
    }


}