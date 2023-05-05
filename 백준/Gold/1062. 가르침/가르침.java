import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String list[] = {"a","n","t","i","c"};
    static String [] word;
    static int N, K , max;
    static boolean checked[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K < 5){
            System.out.println(0);
            return;
        }else if(K == 26){
            System.out.println(N);
            return;
        }

        checked = new boolean[26];
        word = new String[N];
        max = -1;
        for(String s : list){
            checked[s.charAt(0) - 'a'] = true;
        }


        for(int i = 0 ; i < N ;i++){
            String now = br.readLine();
            for(String s: list){
                now = now.replace(s , "");
            }
            word[i] = now;

        }

        dfs(0,0);

        System.out.println(max);


    }
    static void dfs(int start , int cnt){

        if(cnt == K- 5){
            int count = 0;
            for(int i = 0; i < N ;i++){
                boolean read = true;
                for(int j = 0 ; j < word[i].length() ;j++){
                    if(!checked[word[i].charAt(j) - 'a']){
                        read = false;
                        break;
                    }
                }
                if(read) count++;
            }
            max = Math.max(max, count);
            return;
        }

        for(int i = start ; i < 26 ; i++){
            if(!checked[i]){
                checked[i] = true;
                dfs(i , cnt+1);
                checked[i] = false;
            }
        }


    }
}