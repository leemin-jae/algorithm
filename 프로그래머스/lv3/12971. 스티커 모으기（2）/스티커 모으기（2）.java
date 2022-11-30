class Solution {
    static class node{
        int first;
        int second;
        
        node(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public  int solution(int sticker[]) {
        
        node[] node = new node[sticker.length];
        
        node[0] = new node(sticker[0], 0);
        
        if(sticker.length == 1){
            return node[0].first;
        }
        
        node[1] = new node(sticker[0], sticker[1]);
        
        for(int  i = 2; i <sticker.length ; i++){
            int f=0, s =0;
            if(i != sticker.length -1){
             f = sticker[i] + node[i-2].first > node[i-1].first ? sticker[i] + node[i-2].first : node[i-1].first;
             s = sticker[i] + node[i-2].second > node[i-1].second ? sticker[i] + node[i-2].second : node[i-1].second;

            }
            else{
                 f = node[i-1].first;
                 s = sticker[i] + node[i-2].second > node[i-1].second ? sticker[i] + node[i-2].second : node[i-1].second;
            }
            node[i] = new node(f,s);
         }
    
    
        
        return node[sticker.length-1].first > node[sticker.length-1].second ? node[sticker.length-1].first : node[sticker.length-1].second ;
    }
}