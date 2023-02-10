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

        st = new StringTokenizer(br.readLine());
        int balloon[] = new int[N];
        for(int i = 0 ; i < N ;i++){
            balloon[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(balloon);

        long left = 0L;
        long right = (long)balloon[0] * (long)M;

        while(left <= right){

            long mid = (left+right)/2;

            long ans = 0;
            for(int i= 0 ; i <  N ;i++){
                ans += mid/(long)balloon[i];
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