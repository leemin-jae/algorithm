import java.util.PriorityQueue;
import java.util.Collections;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int a : works){
            que.add(a);
        }
        
        for(int i = 0 ; i < n ;i ++){
            int now = (int)que.poll();
            if(now <= 0) break;
            que.add(now-1);
        }
        long sum = 0;
        while(!que.isEmpty()){
            int a = que.poll();
            sum += a*a;
        }
        
        return sum;
    }
}
