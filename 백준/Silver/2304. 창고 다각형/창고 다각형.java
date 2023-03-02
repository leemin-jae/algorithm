import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        StringTokenizer st = null;

        int Map[] = new int[1001];
        int max = Integer.MIN_VALUE;
        int cnt = -1;
        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            Map[w] = h;
            if(max < h){
                cnt = w;
                max = h;
            }
        }

        int sum = 0;
        int h = 0;

        for(int i = 0 ; i < cnt ; i++){
            if(h < Map[i]){
                h = Map[i];
                sum += Map[i];
            }else{
                sum += h;
            }
        }
        h = 0;
        for(int i = 1000; i > cnt ; i--){
            if(h < Map[i]){
                h = Map[i];
                sum += Map[i];
            }else{
                sum += h;
            }
        }

        System.out.println(sum + max);
    }




}