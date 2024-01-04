import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String , String> name = new HashMap<>();
        Map<String, Integer> price = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            name.put(enroll[i], referral[i]);
            price.put(enroll[i], 0);
        }

        for (int i = 0; i < seller.length; i++) {
            sell(name, price, seller[i] , amount[i]*100);
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = price.get(enroll[i]);
        }
        return answer;
    }
    void sell(Map<String , String> name, Map<String, Integer> price ,String seller, int amount ){
        int divide = (int)(amount * 0.1);

        if(divide == 0){
            price.put(seller , price.get(seller) + amount); // 나눠줄 금액이 없으면 본인이 전부 가지고 끝
        }else{
            price.put(seller , price.get(seller) + amount - divide); // 분당금 빼고 내가 가진다.
            String next = name.get(seller);
            if(!"-".equals(next)){ // 본인이 최상위일경우 종료
                sell(name, price , next , divide);
            }
        }
    }
}