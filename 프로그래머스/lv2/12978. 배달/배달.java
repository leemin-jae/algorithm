import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
      
        int Map[][] = new int[N+1][N+1];
        
        for(int i = 0 ; i < road.length ; i ++){
            int from = road[i][0];
            int to = road[i][1];
            int ans = 0;
            if(Map[from][to] == 0){
                ans = road[i][2];
            }else{
                ans = Math.min(Map[from][to] , road[i][2]);
            }
            Map[from][to] = ans;
            Map[to][from] = ans;
        }
        
        int dis[] = new int[N+1];
        boolean visited[] = new boolean[N+1];
        Arrays.fill(dis,123456789);
        
        dis[1] = 0;
        
        for(int cnt = 0 ; cnt < N ; cnt++){
            
            int min = Integer.MAX_VALUE;
            int num = -1;
            for(int i = 1 ; i <= N ; i++){
                if(min > dis[i] && !visited[i]){
                    min = dis[i];
                    num = i;
                }
            }
            
            visited[num] = true;
            
            for(int i = 1 ; i <= N ;i++){
                if(!visited[i] && Map[num][i] != 0){
                    dis[i] = Math.min(dis[i], dis[num] + Map[num][i]);
                }    
            }    
            
        }
        //System.out.println(Arrays.toString(dis));
        int sum = 0;
        for(int i = 1 ; i <= N ;i++ ){
            if(dis[i] <= K){
                sum++;
            }
        }
        

        return sum;
    }
}