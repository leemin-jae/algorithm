import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int envy[] = new int[M];
        for(int i = 0 ; i < M ;i++){
            envy[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(envy);
        long left = 1L;
        long right = (long)envy[envy.length-1];

        while(left <= right){

            long mid = (left+right)/2;
          
            long ans = 0;
            for(int i= 0 ; i <  M ;i++){
                ans += (long)envy[i]/mid;
                if((long)envy[i]%mid != 0) ans++;
            }

            if(ans > N){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(left);
    }

}