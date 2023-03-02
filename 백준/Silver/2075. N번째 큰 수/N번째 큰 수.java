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

        int Map[] = new int[N*N];
        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                Map[i*N + j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(Map);

        System.out.println(Map[N*N - N]);


    }


}