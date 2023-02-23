import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int N, Map[][] , m = 0 , z = 0 , p = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        N = Integer.parseInt(br.readLine());
        Map = new int[N][N];
        for(int i = 0 ; i < N ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j= 0 ; j < N ;j++){
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        spare(0,0,N);

        System.out.println(m);

        System.out.println(z);

        System.out.println(p);


    }
    static public void spare(int x,int y, int k){
        int minus = 0;
        int zero = 0;
        int plus = 0;
        for(int i = x; i < x+ k ;i++){
            for(int j = y ; j < y+ k ; j++){
                if(Map[i][j] == 1){
                    plus++;
                }else if(Map[i][j] == 0){
                    zero++;
                }else{
                    minus++;
                }
            }
        }
        if(minus == k*k){
            m++;
            return;
        }else if(zero == k*k){
            z++;
            return;
        }else if(plus == k*k){
            p++;
            return;
        }

        for(int i = 0 ; i< 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                spare(x + (k/3) * i,y + (k/3) * j,k/3);
            }
        }
    }
}