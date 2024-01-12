import java.util.*;
class Solution {
    static String people = "ACFJMNRT";
    static int num;
    public int solution(int n, String[] data) {
                num = 0;
        dfs(0, new boolean[people.length()] , "" , data);
        return num;
    }
     static public void dfs(int cnt , boolean visited[] ,String line , String[] data){
       if(cnt == people.length()){
                for (String now :  data) {
                    int from = people.indexOf(now.substring(0, 1));
                    int to = people.indexOf(now.substring(2, 3));

                    String op = now.substring(3, 4);
                    int dis = Integer.parseInt(now.substring(4)) + 1;
                    int check = Math.abs(line.indexOf(Integer.toString(from)) - line.indexOf(Integer.toString(to)));

                    if ("=".equals(op)) {
                        if(check != dis) return;
                    }else if (">".equals(op)){
                        if(check <= dis) return;
                    }else
                        if(check >= dis) return;
                }
            num++;
            return;

        }

        for (int i = 0; i < people.length(); i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(cnt+1 , visited , line + i,data);
                visited[i] = false;
            }
        }
    }
}