import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int[] elements) {
        
        int n = Arrays.stream(elements).sum();
        boolean visited[] = new boolean[n+1];
       
        for(int i = 0 ; i < elements.length ; i++){
            
            
            for(int j = 0 ; j < elements.length ; j++){
                int sum = 0;
                for(int k = i ; k <= i + j ; k++){
                    sum += elements[k%elements.length];
                }
                visited[sum] = true;
            }
            
        }
        
        for(int i = 0 ; i < visited.length ; i++){
            if(visited[i]){
                answer++;
            }
        }
        return answer;
    }
}