import java.util.*;

class Solution {
    static List<String> arr;
    static boolean check[];
    static public void dfs(int cnt , String start, String route, String[][] tickets){
        if(cnt == tickets.length){
            arr.add(route);
            return;
        }
        
        for(int i = 0 ; i < tickets.length; i++){
            if(tickets[i][0].equals(start)&&!check[i]){
                check[i] = true;
                dfs(cnt + 1, tickets[i][1] , route + " " + tickets[i][1] , tickets);
                check[i] = false;
            }
        }
    }
    public String[] solution(String[][] tickets) {
        check = new boolean[tickets.length];
        arr = new ArrayList<>();
        
        dfs(0, "ICN" , "ICN" ,tickets);
        
        Collections.sort(arr);
        String [] answer = arr.get(0).split(" ");
        return answer;
    }
}