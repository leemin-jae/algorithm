import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int Max, Min;
    static String Max_String, Min_String;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String check[] = s.split("\\*");

        for(int i = 0 ; i < N ; i++){
            String now = br.readLine();
            if(check[0].length() + check[1].length() > now.length() ){
                System.out.println("NE");
                continue;
            }
            if(now.substring(0,check[0].length()).equals(check[0]) && now.substring(now.length() - check[1].length()).equals(check[1])){
                System.out.println("DA");
            }else{
                System.out.println("NE");
            }


        }

    }


}