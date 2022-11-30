import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        boolean [][] vertex = new boolean[n+1][n+1];
        
        for(int i =0 ; i < edge.length ; i++){
            vertex[edge[i][0]][edge[i][1]] = true;
            vertex[edge[i][1]][edge[i][0]] = true;
        }
        
        int dis[] = new int[n+1];
        boolean visited[] = new boolean[n+1];
        
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        dis[1] = 0;
        
        for(int i = 1; i <= n ; i++ ){
            int min = Integer.MAX_VALUE , current = 0;
            for(int j = 1 ; j <= n ; j++){
                if(!visited[j] && dis[j] < min){
                    min = dis[j];
                    current = j;
                }
            }
            
            visited[current] = true;
            
            for(int j = 1; j <= n ; j++){
                if(!visited[j] && vertex[current][j] && dis[j] > dis[current] + 1){
                    dis[j] = dis[current] + 1;
                }
            }            
            
        }
        
        Arrays.sort(dis);
        int answer = 0;
        for(int i = 0 ; i < n ;i++){
            if(dis[i] == dis[n-1]) answer++;
        }
        

        return answer;
    }
}