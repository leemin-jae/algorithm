import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int delta[][] = {{1,0},{0,1},{-1,0},{0,-1}} , Map[][] , N, Min;
    static boolean checked[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());



        for(int T = 0 ; T < tc ;T++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int check[] = new int[26];
            String s = br.readLine();
            int N = Integer.parseInt(br.readLine());
            for(int i = 0 ; i< s.length() ; i++){
                check[s.charAt(i) -'a']++;
            }

            for(int i = 0 ; i< s.length() ; i++){
                if(check[s.charAt(i) -'a'] >= N){
                    int cnt = 0;
                    int len = 0;
                    for(int k = i ; k < s.length() ;k++ ){
                        if(s.charAt(k) == s.charAt(i)) cnt++;
                        len++;
                        if(cnt == N) break;
                    }
                    max = Math.max(max, len);
                    min = Math.min(min , len);
                    check[s.charAt(i) -'a']--;
                }
            }

            if(max == Integer.MIN_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(min + " " + max);
            }





        }
    }

}