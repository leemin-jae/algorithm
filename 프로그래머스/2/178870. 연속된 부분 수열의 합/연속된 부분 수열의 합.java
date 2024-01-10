class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int sum[] = new int[sequence.length+1];
        for (int i = 1; i <= sequence.length; i++) {
            sum[i] = sum[i-1] + sequence[i-1];
        }
        int start = 1;
        int end = 1;
        int [] answer = new int[2];
        int min = Integer.MAX_VALUE;
        while (end <= sequence.length && start <= end){
            int num  = sum[end] - sum[start -1];
            if(num == k){
                if(min > ( end - start )){
                    min = (end-start);
                    answer[0] = start-1;
                    answer[1] = end-1;
                }
                end++;
            } else if (num < k) {
                end++;
            }else {
                start++;
            }
        }

        return answer;
    }
}