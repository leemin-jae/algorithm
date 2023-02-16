import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        long N = Long.parseLong(br.readLine());



        int now = 1;

        while(true){
            if(N - (long)Math.pow(2,now) <= 0){
                break;
            }
            N -= (long)Math.pow(2,now);
            now++;
        }

        String s = "";
        while(now != 0){

            long check = N - (long)Math.pow(2,now-1);
            if(check <= 0){
                s+= "4";
            }else{
                N -= (long)Math.pow(2,now-1);
                s+= "7";
            }

            now--;
        }

        System.out.println(s);






    }

}