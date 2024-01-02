import java.util.*;
class Solution {
    static Set<Integer> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
         int answer = 0;
        boolean checked[][] = new boolean[user_id.length][banned_id.length];

        for (int i = 0; i < user_id.length; i++) {
            for (int j = 0; j < banned_id.length; j++) {
                if (user_id[i].length() != banned_id[j].length()) continue;
                checked[i][j] = true;
                for (int k = 0; k < user_id[i].length(); k++) {
                    if(banned_id[j].charAt(k) == '*') continue;
                    if(user_id[i].charAt(k) != banned_id[j].charAt(k)){
                        checked[i][j] = false;
                        break;
                    }
                }
            }
        }


//        for (int i = 0; i < user_id.length; i++) {
//            for (int j = 0; j < banned_id.length; j++) {
//                System.out.print(checked[i][j]?"1" : "0");
//            }
//            System.out.println();
//        }

        cul(0 , 0 , checked);
        answer = set.size();
        return answer;
    }
    public void cul(int cnt ,int isUsed , boolean checked[][]){
        if(cnt == checked[0].length){
            set.add(isUsed);
            return;
        }
        for (int i = 0; i < checked.length; i++) {
            if((isUsed & (1 << i)) == 0 && checked[i][cnt]){
                cul(cnt + 1 , (isUsed | (1 << i)) , checked);
            }
        }

    }
}