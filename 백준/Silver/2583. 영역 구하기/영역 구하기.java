import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int delta[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean checked[][] = new boolean[M][N];

        for(int cnt = 0 ; cnt < K ;cnt++){
            st = new StringTokenizer(br.readLine());

            int l_x = Integer.parseInt(st.nextToken());
            int l_y = Integer.parseInt(st.nextToken());
            int r_x = Integer.parseInt(st.nextToken());
            int r_y = Integer.parseInt(st.nextToken());


            for(int i = l_x; i< r_x; i++){
                for(int j = l_y ; j < r_y ; j++){
                    checked[i][j] = true;
                }
            }

        }
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < M; i++){
            for(int j = 0 ; j < N ; j++){
                if(!checked[i][j]){
                    int sum = 0;
                    Queue<int[]> que = new LinkedList<>();
                    que.add(new int[] {i,j});
                    checked[i][j] = true;

                    while (!que.isEmpty()){
                        int now[] = que.poll();
                        sum++;
                        for(int m = 0 ; m < 4 ; m++){
                            int nextX = now[0] + delta[m][0];
                            int nextY = now[1] + delta[m][1];

                            if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || checked[nextX][nextY]) continue;
                            que.add(new int[] {nextX, nextY});
                            checked[nextX][nextY] = true;
                        }


                    }
                    list.add(sum);


                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int a : list){
            System.out.print(a + " ");
        }
        

    }

}