import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int Map[] = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++){
            Map[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        while(Arrays.stream(Map).sum() != 0){
            for(int i = 0 ; i < Map.length ; i++){
                if(Map[i] % 2 == 1){
                    Map[i]--;
                    sum++;
                }
            }

            if(Arrays.stream(Map).sum() != 0){
                for(int i = 0 ; i < Map.length ; i++){
                        Map[i] = Map[i]/2;
                }
                sum++;
            }
        }

        System.out.println(sum);
    }

}