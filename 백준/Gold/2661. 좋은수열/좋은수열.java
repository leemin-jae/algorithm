import java.io.*;
import java.util.*;


public class Main {
    static int N;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        fun(0,"");
        

    }
    static public void fun(int cnt , String s){

        if(cnt == N){
            System.out.println(s);
            System.exit(0);
            return;
        }

        for(int i = 1; i <= 3; i++){
            if(check(s + i)){
                fun(cnt + 1, s + i);
            }
        }

    }
    static public boolean check(String s){

        int route = s.length()/2;

        for(int i = 1 ; i <= route ; i++){
            if(s.substring(s.length() - 2*i,  s.length() - i).equals(s.substring( s.length() - i))){
                return false;
            }

        }
        return true;

    }

}