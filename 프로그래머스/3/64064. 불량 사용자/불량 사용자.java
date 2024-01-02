import java.util.*;
class Solution {
    Set<Integer> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        cul(0 , 0, user_id , banned_id);
        answer = set.size();
        return answer;
    }
    public void cul(int cnt ,int isUsed , String[] user_id, String[] banned_id){  // 정규식을 이용한 풀이
        if(cnt == banned_id.length){
            set.add(isUsed);
            return;
        }

        String reg = banned_id[cnt].replace("*", "[\\w\\d]");
        for (int i = 0; i < user_id.length; i++) {
            if((isUsed & (1 << i)) == 0 && user_id[i].matches(reg)){
                cul(cnt + 1 , (isUsed | (1 << i)) , user_id , banned_id);
            }
        }

    }
}