import java.util.*;
class Solution {
    static int[][] com;
    static int N, cnt;
    static boolean[] check;
    
    public static void bfs(int k){
        Queue<Integer> que = new LinkedList<>();
        que.add(k);
        check[k] = true;
        
        while(!que.isEmpty()){
            int now = que.poll();   
            
            for(int i = 0 ; i < N ; i++){
                if(!check[i] && com[now][i] == 1){
                    que.add(i);
                    check[i] = true;
                }
            }
        
        }
        
        
    }
    
    public int solution(int n, int[][] computers) {
        com = computers;
        N = n;
        cnt = 0;
        check = new boolean[n];
        
        for(int i = 0 ; i < n ; i++){
            if(!check[i]){
                bfs(i);
                cnt++;
            }
        }
        
        return cnt;
    }
}