import java.util.*;
class Solution {
    public int solution(int[][] t) {
        
        int n = t.length;
        
        int dp[][] = new int[n][n];
        
        for(int i = 0 ; i < n ; i++){
            dp[n-1][i] = t[n-1][i];
        }
        
        if(n > 1){
        
            for(int i = n-2 ; i >= 0 ; i--){
                for(int j = 0 ; j <= i; j++){
                    dp[i][j] = Math.max(t[i][j] + dp[i+1][j],t[i][j] + dp[i+1][j+1]);
                }
            }
        }
        
        return dp[0][0];
    }
}