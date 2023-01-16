import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> list = new HashSet<>();
        for(int i = 0; i < N ;i++){
            list.add(br.readLine());
        }

        for(int cnt = 0 ; cnt < M ; cnt++){
            st = new StringTokenizer(br.readLine(),",");
            while(st.hasMoreTokens()){
                String now = st.nextToken();
                if(list.contains(now)){
                    list.remove(now);
                }
            }
            System.out.println(list.size());

        }

    }



}