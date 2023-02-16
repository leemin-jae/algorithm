class Solution {
    public String solution(int N) {
        
        
        
        int now = 1;

        while(true){
            if(N - (long)Math.pow(3,now) <= 0){
                break;
            }
            N -= (long)Math.pow(3,now);
            now++;
        }

        String s = "";
        while(now != 0){

            long check = (long)Math.pow(3,now-1);
            if((N-1)/check == 2){
                N -= (long)Math.pow(3,now-1)*2;
                s+= "4";
            }else if((N-1)/check == 1){
                N -= (long)Math.pow(3,now-1)*1;
                s+= "2";
            }else if((N-1)/check == 0){
                s+= "1";
            }

            now--;
        }

       
        return s;
    }
}