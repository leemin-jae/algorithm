import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        
        String s = br.readLine();

        char c = s.charAt(0);
        int i = 1;
        for (; i < s.length(); i++) {
            if (c!=s.charAt(i)) break;
        }
        if (i==s.length()) {
            System.out.println(-1);
            return;
        }
        i = 0;
        for (; i < s.length()/2; i++) {
            if (s.charAt(i)!=s.charAt(s.length()-1-i)) break;
        }
        System.out.println(i==s.length()/2?s.length()-1:s.length());
     


    }
}