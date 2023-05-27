import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {

        String first = br.readLine();
        String second = br.readLine();
        int N = 0;
        String std = null;
        String cp = null;

        if(first.length() < second.length()){
            std = first;
            cp = second;
            N = first.length();
        }else{
            std = second;
            cp = first;
            N = second.length();
        }

        int Map[] = new int [N];

        for(int i = 0 ; i < N; i++){
            if(cp.contains(std.substring(i , i+1))){
                Map[i] = 1;
            }
        }

//        System.out.println(Arrays.toString(Map));
//
        int max = 0;
        for(int i = 1 ; i < N ; i++){   // 길이

            if(Map[i] != 0 ){
                    int start = i - Map[i-1];
                    int end = i+1;
                    for(int j = start  ; j < end ; j++){
                        if(cp.contains(std.substring(j , end))){
//                            System.out.println(std.substring(j , end));
                            Map[i] = end - j;
                            break;
                        }

                }
                    max = Math.max(max, Map[i]);
            }

        }

        System.out.println(max);

    }



}