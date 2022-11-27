class Solution {
    public boolean solution(int x) {
        int now = x;
        int sum = now%10;
        int k = 10000;
        while(k != 1){
            sum += now/k;
            now = now - (now/k)*k;
            k = k/10;
        }
        if(x%sum == 0){
            return true;
        }else{
            return false;
        }
    }
}