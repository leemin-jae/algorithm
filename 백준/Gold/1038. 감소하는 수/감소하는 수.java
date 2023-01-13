import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());

        if(N <= 10){
            System.out.println(N);

        }else if(N >1022){
            System.out.println(-1);
        }
        else{
            for(int i = 0; i < 10; i++){
                back(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(N));
        }
        
    }
    static public void back(long cnt , int k){
        if(k > 10) return;
        list.add(cnt);
        for(int i = 0 ; i < cnt % 10 ; i++){
            back((cnt*10) + i , k + 1);
        }
    }

}