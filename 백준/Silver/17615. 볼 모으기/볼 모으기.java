import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < N ;i++){
            stack.push(s.charAt(i));
        }

        boolean check = false;
        int cnt = 0;
        while(!stack.isEmpty()){
            if(stack.peek() == 'R'){
                if(check){
                    cnt++;
                    check = false;
                    stack.pop();
                    stack.push('B');
                }else{
                    stack.pop();
                }
            }else{
                check = true;
                stack.pop();
            }
        }

        stack = new Stack<>();
        for(int i = 0 ; i < N ;i++){
            stack.push(s.charAt(i));
        }

        boolean B_check = false;
        int B_cnt = 0;
        while(!stack.isEmpty()){
            if(stack.peek() == 'B'){
                if(B_check){
                    B_cnt++;
                    B_check = false;
                    stack.pop();
                    stack.push('R');
                }else{
                    stack.pop();
                }
            }else{
                B_check = true;
                stack.pop();
            }
        }
        System.out.println(B_cnt > cnt ? cnt : B_cnt);

    }
}