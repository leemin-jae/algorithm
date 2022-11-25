class Solution {
    
    static String t;
    static int max;
    
    
    static public boolean minus(String now , String next){
        int count =0;
        for(int i = 0 ; i < now.length(); i++){
            if(now.charAt(i) != next.charAt(i)){
                count++;
            }
        }
        if(count > 1){
            return false;
        }else{
            return true;
        }
    }
    
    public static void dfs(String[] words,String std,boolean[] check, int cnt){
        if(std.equals(t)){
            max = max>cnt?cnt:max;
            return;
        }
        for(int i = 0 ; i < words.length; i++){
            if(!check[i] && minus(std, words[i])){
                check[i] = true;
                dfs(words,words[i],check , cnt+1);
                check[i] = false;
            }
        }
    }
    
    
    public int solution(String begin, String target, String[] words) {
        boolean flag = false;
        for(int i = 0 ; i < words.length ; i++){
            if(words[i].equals(target)){
                flag = true;
            }
        }
        
        if(!flag) return 0;
        
        t = target;
        max = 9999999;
        
        dfs(words, begin, new boolean[words.length],0);
        
        return max;
        
    }
}