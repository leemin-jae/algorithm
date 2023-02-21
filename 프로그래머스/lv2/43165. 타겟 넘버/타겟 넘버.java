class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        check(0,0,numbers,target);
        return answer;
    }
    static public void check(int i , int cnt ,int[] numbers ,int target){
        if(i == numbers.length){
            if(cnt == target){
                answer++;
            }
            return;
        }
        check(i+1, cnt + numbers[i], numbers, target);
        check(i+1, cnt - numbers[i], numbers, target);
    }
}