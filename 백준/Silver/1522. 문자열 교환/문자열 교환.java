import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static char Map[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int len= s.length();
        int cnt = 0;
        for(int i = 0 ; i < len ; i ++){
            if(s.charAt(i) == 'a'){
                cnt++;
            }
        }
        int result = cnt;
        for(int i =0 ; i < len ;i++){

            int Bcnt = 0;
            for(int j = i ; j < i +cnt; j++){
                if(s.charAt(j%len) == 'b'){
                    Bcnt++;
                }
            }

            result = Math.min(result, Bcnt);

        }


        System.out.println(result);

    }
}