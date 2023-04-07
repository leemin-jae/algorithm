import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int cnt = 0;

            int Map[][] = new int[M][2];

            for(int i = 0 ; i< M ;i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                Map[i][0] = start;
                Map[i][1] = end;

            }
            Arrays.sort(Map, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] == o2[1]? o1[0] - o2[0] : o1[1] - o2[1];
                }
            });
            boolean[] checked = new boolean[N + 1];
            for(int i = 0 ; i< M ;i++){

                int start = Map[i][0];
                int end = Map[i][1];

                for(int j = start ; j <= end ; j++){
                    if(!checked[j]){
                        checked[j] = true;
                        cnt++;
                        break;
                    }
                }
            }

            System.out.println(cnt);

        }




    }


}