import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N , Min, Max, M;

    static int delta[][] = {{0,1},{1,0},{-1,0},{0,-1}};


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> plus = new PriorityQueue<>();
        PriorityQueue<Integer> minus = new PriorityQueue<>(Comparator.reverseOrder());

        int Max = 0;
        int Min = 0;

        for(int i= 0 ; i < N ;i++){
            int now = Integer.parseInt(st.nextToken());
            if(now < 0 ){
                Min = Math.min(Min, now);
                minus.add(now);
            }else{
                Max = Math.max(Max, now);
                plus.add(now);
            }
        }

        int sum = 0;

        int first = minus.size()%M==0?M:minus.size()%M;
        int cicle = minus.size()%M==0?minus.size()/M : minus.size()/M +1;

        for(int i = 1 ; i <= cicle; i++){
            int num = 0;
            for(int j = 0 ; j < first; j++){
                num = Math.abs(minus.poll());
            }
            if(cicle == i && Math.abs(Min) >= Max){
                sum += num;
            }else{
                sum += num*2;
            }
            first = M;
        }


        first = plus.size()%M==0?M:plus.size()%M;
        cicle = plus.size()%M==0?plus.size()/M : plus.size()/M +1;

        for(int i = 1 ; i <= cicle; i++){
            int num = 0;
            for(int j = 0 ; j < first; j++){
                num = plus.poll();
            }
            if(cicle == i && Math.abs(Min) < Max){
                sum += num;
            }else{
                sum += num*2;
            }
            first = M;
        }


        System.out.println(sum);



    }

}