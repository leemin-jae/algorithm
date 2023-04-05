import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int count[], result;
    static boolean checked[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int Map[][] = new int[N][2];

        StringTokenizer st = null;
        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            Map[i][0] = Integer.parseInt(st.nextToken());
            Map[i][1] = Integer.parseInt(st.nextToken());
        }
        solution(N, Map);
    }

    public static void solution(int n, int Map[][]) {


        Arrays.sort(Map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1] ;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i= 0 ; i < n ;i++){
            sb.append(Map[i][0] + " " + Map[i][1] + "\n");
        }

        System.out.println(sb);

    }


}