import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
     static int N;
    static boolean check[];

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        if(N == 1){
            System.out.println(0);
            System.exit(0);
        }
        int Map[] = new int[N+1];
        Arrays.fill(Map,1);
        Map[0] = 0;
        Map[1] = 0;
        for(int i = 2 ;i < N+1 ; i++){
            if(Map[i] == 1){
                list.add(i);
                int now = i*2;
                while (now <= N){
                    Map[now] = 0;
                    now += i;
                }
            }
        }





        int left = list.size()-1;
        int right = list.size()-1;

        int num = list.get(left);
        int sum = 0;
        while(true){
            if(num < N){
                left--;
                if(left < 0) break;
                num += list.get(left);
            }else if(num == N){
                sum++;
                num -= list.get(right);
                right--;
            }else{
                num -= list.get(right);
                right--;
            }

        }
        System.out.println(sum);


    }



}