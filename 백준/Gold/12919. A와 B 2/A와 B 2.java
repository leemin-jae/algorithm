import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String S,T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();



        System.out.println(        find(S,T));
    }

    static public int find(String S, String T){

        if(S.length() == T.length()){
            if(S.equals(T)){
                return 1;
            }
            return 0;
        }
        int ans = 0;
        if(T.charAt(0) == 'B'){
            String s = T.substring(1);
            StringBuilder sb = new StringBuilder(s);
            ans += find(S,sb.reverse().toString());
        }

        if(T.charAt(T.length() -1) == 'A'){
            ans += find(S, T.substring(0,T.length()-1));
        }

        return ans > 0 ? 1: 0;


    }

}