class Solution {
    public static boolean check(int[] stones, int k, int mid){
        int cnt = 0;
        for(int i = 0 ; i  < stones.length ;i++){
            if(stones[i] < mid ){
                cnt++;
            }else{
                cnt = 0;
            }
            if(cnt == k)
                return false;
        }
        return true;
        
    }
    public int solution(int[] stones, int k) {
        int cnt  =0 ;
        int min = 0;
        int max = 200000001;
        
        while(min <= max){
            int mid = (max+min)/2;
            if(check(stones,k,mid)){
                min = mid +1;
                cnt = mid;
            }else{
                max = mid - 1;
            }
            
        }
            
        return cnt;
    }
}