import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String,String> map = new HashMap<>();
        Queue<String [] > que = new LinkedList<>();
        
        for(int i = 0 ; i < record.length ; i++){
            String now[]  = record[i].split(" ");
        
            if(now[0].equals("Enter")){
              
                map.put(now[1], now[2]);
                que.add(new String[] {now[1], now[0]});        
            }else if(now[0].equals("Change")){
                
                map.put(now[1], now[2]);
            }else{
                
             
                que.add(new String[] {now[1], now[0]});
            }
        
            
        }
        
        
        
        List<String> list = new ArrayList<>();
        
        while(!que.isEmpty()){
            String s[] = que.poll();
            if(s[1].equals("Enter")){
                list.add( map.get(s[0]) + "님이 들어왔습니다.");
            }else{
                list.add(map.get(s[0]) + "님이 나갔습니다.");
            }
        }
        
        String[] answer = list.toArray(new String[list.size()]);
           
        return answer;
    }
}