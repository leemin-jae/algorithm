import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, arr[], max;
    static List<Integer> list;

    static boolean []visited, check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        visited = new boolean[N+1];
        check = new boolean[N+1];
        list = new ArrayList<>();
        max = Integer.MIN_VALUE;

        for(int i = 1 ; i < N+1 ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


        for(int i = 1 ; i <= N ;i++){
            visited[i] = true;
            max = i;
            dfs(i);
            visited[i] =false;
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(int i : list){
            System.out.println(i);
        }

    }

    static public void dfs(int cnt){

        if(arr[cnt] == max) list.add(max);

        if(!visited[arr[cnt]]) {
            visited[arr[cnt]] = true;
            dfs(arr[cnt]);
            visited[arr[cnt]] = false;
        }


    }

}