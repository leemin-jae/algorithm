class Solution {
    public int solution(String s) {
        int answer = 10000;
        for(int i = 1 ; i <= s.length() ;i++){
          
            
            StringBuilder sb = new StringBuilder();
            String check = s.substring(0 , i);
            int num = 1;
            int j = i;
            for(; j <= s.length() - i ; j+=i){
                String next = s.substring(j , j+i);
                if(check.equals(next)){
                    num++;
                }else{
                    if(num == 1){
                        sb.append(check);
                    }else{
                        sb.append(num).append(check);
                    }
                    check = next;
                    num = 1;
                }

            }
            if(num == 1){
                sb.append(check);
            }else{
                sb.append(num).append(check);
            }
            
            
            sb.append(s.substring(j));
            
            answer = Math.min(answer , sb.toString().length());
            
            
        }
        
        return answer;
    }
}