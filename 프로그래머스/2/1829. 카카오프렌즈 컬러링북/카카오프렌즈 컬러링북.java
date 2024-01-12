import java.util.*;
class Solution {
    int[][] delta = {{0,1},{1,0},{-1,0},{0,-1}};
    public int[] solution(int m, int n, int[][] picture) {
                int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !visited[i][j]){
                    numberOfArea++;
                    int size = 0;
                    Queue<int []> queue = new LinkedList<>();
                    queue.add(new int[]{i , j});
                    visited[i][j] = true;
                    
                    while (!queue.isEmpty()){
                        int [] now = queue.poll();
                        size++;
                        for (int k = 0; k < 4; k++) {
                            int x = now[0] + delta[k][0];
                            int y = now[1] + delta[k][1];
                            
                            if(x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || picture[x][y] != picture[i][j]) continue;
                            queue.add(new int[]{x,y});
                            visited[x][y] = true;
                            
                        }
                        
                    }
                    
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                    
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}