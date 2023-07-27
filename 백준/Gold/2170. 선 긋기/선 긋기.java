import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N , Min, Max, M;

    static int delta[][] = {{0,1},{0,-1},{1,0},{-1,0}};



    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        int Map[][] = new int[N][2];

        for(int i = 0 ; i < N;i++){
            st = new StringTokenizer(br.readLine());
            Map[i][0] = Integer.parseInt(st.nextToken());
            Map[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        Min = Map[0][0];
        Max = Map[0][1];
        int sum =0;
        for(int i = 1 ; i < N;i++){
            if(Map[i][0] > Max){
                sum += (Max - Min);
                Min = Map[i][0];
                Max = Map[i][1];
            }else{
                Max = Math.max(Max,Map[i][1]);
                Min = Math.min(Min,Map[i][0]);
            }
        }

        sum+= (Max - Min);

        System.out.println(sum);






    }

}