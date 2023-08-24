import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N , Min, Max, M , K, X , P;

    static int delta[][] = {{0,1},{0,-1},{1,0},{-1,0},{0,0}};

    static int Map[][] , arr[], seg[];
    static boolean checked[];



    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        seg = new int[N * 4];
        segInit(1 , 0 , N-1);

        StringBuilder sb = new StringBuilder();
        for (int i = M-1; i <= N - M ; i++) {
            sb.append(find(1 , 0 , N-1 , i - (M-1) , i + (M-1)) + " ");
        }

        System.out.println(sb);

    }
    static public int segInit ( int node, int s, int e){
        if(s == e){return seg[node] = arr[s];}
        int mid = (s+e)/2;
        return seg[node] = Math.max(segInit(2*node , s , mid) , segInit(2*node+1 , mid + 1, e));
    }
    static public int find(int node, int s, int e, int left, int right){
        if(right < s || left > e) return -1;
        else if (left <= s && right >= e){
            return seg[node];
        }else{
            int mid = (s + e)/2;
            return Math.max(find(2*node , s , mid, left, right), find(2*node + 1 , mid + 1 , e , left , right));
        }
    }

}