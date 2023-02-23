import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        String std = "";
        for(int i = 0 ; i < 2*N+1 ; i++){
            if(i%2 == 0){
                std += "I";
            }else{
                std += "O";
            }
        }
        //ystem.out.println(std);

        String s = br.readLine();


        int sum = 0;
        for(int i = 0 ; i <= s.length() - (N*2 + 1) ; i ++){
            if(s.charAt(i) == 'I'){
                if(s.substring(i,i+2*N+1).equals(std)){
                    sum++;
                }
            }
        }

        System.out.println(sum  );


    }
}