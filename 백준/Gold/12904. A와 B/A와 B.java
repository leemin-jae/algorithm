import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        while(true){
            int size = B.length();
            if(size == A.length()){
                System.out.println(A.equals(B)?1:0);
                break;
            }
            if(B.charAt(size-1) == 'A'){
                B = B.substring(0,size-1);
            }else{
                B = B.substring(0,size-1);
                StringBuilder sb = new StringBuilder(B);
                B = sb.reverse().toString();
            }


        }

    }

}