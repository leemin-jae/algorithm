import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        int s = 1;

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){

            int now = Integer.parseInt(br.readLine());

            if(cnt <= now){
                for(int j = s ;  j <= now ; j++){
                    stack.push(s);
                    sb.append("+\n");
                    s++;
                }
            }else if (cnt > now){
                sb = new StringBuilder("NO");
                break;
            }

            stack.pop();
            sb.append("-\n");
            if(stack.isEmpty()){
                cnt = 0;
            }else{
                cnt = stack.peek();
            }
        }

        System.out.println(sb);
    }
}