import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int cnt;
        int h;
        Node(int cnt, int h){
            this.cnt = cnt;
            this.h = h;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int Map[] = new int[M];

        for(int i = 0 ; i<  M ;i ++){
            Map[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for(int i = 1 ; i < M-1; i++){

            int left = -1;

            for(int j = i-1 ; j >= 0 ; j--){
                left = Math.max(left, Map[j]);
            }

            int right = -1;

            for(int j = i + 1; j < M ;j++){
                right = Math.max(right, Map[j]);
            }

            if(left > Map[i] && right > Map[i]){
                sum += Math.min(left,right) - Map[i];
            }

        }

        System.out.println(sum);


    }
}