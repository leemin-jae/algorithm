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

        List<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i <= N ;i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list.get(t).add(f);
        }


        int check[] = new int[N+1];

        Queue<Integer> queue = new LinkedList<>();

        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i <= N ;i++){
            int s = 1;
            queue.add(i);
            boolean visited[] = new boolean[N+1];
            visited[i] = true;

            while(!queue.isEmpty()){
                int now = queue.poll();

                for(int k : list.get(now)){
                    if(!visited[k]){
                        queue.add(k);
                        s++;
                        visited[k] = true;
                    }
                }
            }
            check[i] = s;

            max = Math.max(max, s);
        }

        for(int  i = 1 ; i <= N ; i++){
            if(max == check[i]){
                System.out.print(i + " ");
            }
        }


    }

}