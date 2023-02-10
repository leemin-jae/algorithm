import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int space = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ap[] = new int[26];

        for(int i = 0 ; i < 26 ; i++){
            ap[i] = Integer.parseInt(st.nextToken());
        }


//
//        System.out.println((int)'A');
//
//        System.out.println((int)'Z');
//
//        System.out.println((int)'a');
//
//        System.out.println((int)'z');

        int std = (int)s.charAt(0);
        int index = -1;
        if(std - 97 < 0){
            index = std-65;
        }else{
            index = std-97;
        }


        if(ap[index] == 0){
            System.out.println(-1);
            return;
        }else{
            ap[index]--;
        }


        for(int i = 1 ; i < s.length() ;i++){

            int now = (int)s.charAt(i);
            if(now == std) continue;

            if(now == 32){
                if(space == 0){
                    System.out.println(-1);
                    return;
                }else{
                    space--;
                }
            }else{
                if(now - 97 < 0){
                    index = now-65;
                }else{
                    index = now-97;
                }

                if(ap[index] == 0){
                    System.out.println(-1);
                    return;
                }else{
                    ap[index]--;
                }
            }
            std = now;
        }

        String a = "";

        st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            String c = Character.toString(st.nextToken().charAt(0)).toUpperCase();
            a += c;
            if(ap[(int)c.charAt(0)-65] == 0){
                System.out.println(-1);
                return;
            }else{
                ap[(int)c.charAt(0)-65]--;
            }
        }

        System.out.println(a);


    }

}