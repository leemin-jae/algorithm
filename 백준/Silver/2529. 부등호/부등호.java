import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int Max, Min,  N;
    static char Map[], result[];
    static Stack<String> queue = new Stack<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Map = new char[N];
        for(int i = 0 ; i < N ; i ++){
            Map[i] = st.nextToken().charAt(0);
        }


        result = new char[N+1];

        dfs(0 , new boolean[10]);

        while (!queue.isEmpty()){
            System.out.println(queue.pop());
        }
    }

    static public void dfs(int cnt , boolean []checked){



        if(cnt == N+1){
            if (queue.size() < 2){
                queue.add(String.valueOf(result));
            }else{
                queue.pop();
                queue.add(String.valueOf(result));
            }
            return;
        }




        for(int i = 0 ; i < 10; i++){
            if(!checked[i]){
                if(cnt != 0){
                    if((Map[cnt-1] == '<' && result[cnt-1] - '0' > i) || (Map[cnt-1] == '>' && result[cnt-1] - '0' < i)){
                        continue;
                    }
                }
                checked[i] = true;
                result[cnt] = (char)('0' + i);
                dfs(cnt+1 , checked);
                checked[i] = false;
            }

        }

    }


}