import java.util.*;
class Solution {
    public int[] solution(long begin, long end) {
   int N = (int) (end - begin + 1);
        int[] answer = new int[N];
        Arrays.fill(answer , 1);


        for (int i = (int)begin; i <= (int)end ; i++) {
            int minValue = 1;
            for (int j = 2; j <= (int)Math.sqrt(i); j++) {
//                if(!isPriam[j] && i % j == 0){
                if(i % j == 0){
                    // System.out.println(i + " " + j + " " + i/j);
                    if(i/j > 10000000){
                        minValue = j;
                    }else {
                        answer[i - (int) begin] = i/j;
                        break;
                    }
                }
            }
            answer[i - (int) begin] =Math.max(answer[i - (int) begin] , minValue);
        }
        if(begin == 1){
            answer[0] = 0;
        }
        return answer;
    }
}