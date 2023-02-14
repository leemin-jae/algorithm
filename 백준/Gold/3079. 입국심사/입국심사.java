import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        long time[] = new long[(int)N];

        for(int i = 0 ; i < N ;i++){
            time[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(time);

        long left = 0L;
        long right = time[(int)N-1] * M;


        while(left <= right){
            long mid = (left+right)/2;

            long ans = 0;
            for(int i = 0 ; i < N ;i++){
                ans += (long)mid/(long)time[i];
            }

            if(ans < M){
                left = mid+1;
            }else{
                right = mid-1;
            }

        }
        System.out.println(left);

    }

}