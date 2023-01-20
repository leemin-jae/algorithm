import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static List<int[]> list[];
    static int N, D, res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.valueOf(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int T = 0 ; T <tc ;T++){

            int n = Integer.valueOf(br.readLine());
            if(n == 0){
                if(que.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(que.poll());
                }
            }else{
                que.add(n);
            }


        }


    }
}