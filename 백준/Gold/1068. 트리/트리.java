import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, tree[];
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(br.readLine());

        tree = new int[N];
        for(int i = 0 ; i< N ;i++){
            int now = Integer.parseInt(st.nextToken());
            tree[i] = now;
        }

        check = new boolean[N];

        delete_tree(M);
        int sum = 0;
        for(int i = 0 ; i < N ;i++){
            if(!check[i] && find_leaf(i)){
                sum++;
            }
        }

        System.out.println(sum);
    }
    static public void delete_tree(int cnt){

        check[cnt] = true;

        for(int i = 0 ; i < N ;i++){
            if(tree[i] == cnt){
                delete_tree(i);
            }
        }
    }
    static public boolean find_leaf(int cnt){
        for(int i = 0 ; i< N ;i++){
            if(!check[i] && tree[i] == cnt){
                return false;
            }
        }
        return true;
    }
}