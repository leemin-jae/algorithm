import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        for(int i = 0 ; i < N ;i++){
            st = new StringTokenizer(br.readLine());
            que.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        st = new StringTokenizer(br.readLine());
        int arrival = Integer.parseInt(st.nextToken());
        int curFuel = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> fuel = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        while (curFuel < arrival){

            while (!que.isEmpty() && que.peek()[0] <= curFuel) fuel.add(que.poll()[1]);

            if(fuel.isEmpty()) {
                System.out.println(-1);
                return;
            }
            ans++;
            curFuel += fuel.poll();

        }

        System.out.println(ans);


    }


}