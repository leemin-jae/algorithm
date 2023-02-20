class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        
        
        int[][] Map = new int[key.length*2 + lock.length][key.length*2 + lock.length];
        
       
        
        for(int i = key.length; i < key.length+lock.length ; i++){ 
            for(int j = key.length; j < key.length+lock.length ; j++){
                Map[i][j] = lock[i-key.length][j-key.length];
            }
        }
        
        
        for(int cnt = 0 ; cnt < 4 ;cnt++){ // key 돌리기 배열
        
            int[][] keys = copy(key, cnt);
            
            for(int i = 0 ; i < keys.length ; i++){
                for(int j = 0; j < keys.length ; j++){
                    
                    System.out.print(keys[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("------------");
            
            for(int i = 0; i < key.length+lock.length ; i++){   // key 가중치
                for(int j = 0; j < key.length+lock.length ; j++){

                    for(int x = 0 ; x < key.length ; x++){       // lock에 키를 더함
                        for(int y = 0; y < key.length ; y++){
                            Map[x+i][y+j] += keys[x][y]; 
                        }
                    }

                    int sum = 0;                             // 석판이 풀렸는지 계산
                    for(int x = key.length ; x < key.length+lock.length ; x++){
                        for(int y = key.length; y < key.length+lock.length ; y++){
                            if(Map[x][y] == 1){
                                sum += Map[x][y];    
                            }
                        }
                    }
                    if(sum == lock.length*lock.length){  // 풀릴수 있으면 리턴
                        for(int x = key.length ; x < key.length+lock.length ; x++){
                        for(int y = key.length; y < key.length+lock.length ; y++){
                             System.out.print(Map[x][y] + " ");
                        }
                            System.out.println();
                    }
                        return true;
                    }

                    for(int x = 0 ; x < key.length ; x++){      // 안되면 다시 돌려놓음
                        for(int y = 0; y < key.length ; y++){
                            Map[x+i][y+j] -= keys[x][y]; 
                        }
                    }

                }
            }
        }    
        return false;  // 다했는데 틀리면 들렸다고 리턴
    }
    
    public static int[][] copy(int[][] key, int cnt){
        int[][] copy = new int[key.length][key.length];
        int N = key.length;
        if(cnt == 0){
            for(int i = 0 ; i < N ; i++){  // 정위치
                for(int j = 0 ; j < N ; j++){
                        copy[i][j] = key[i][j];
                }
            }
        }else if(cnt == 1){
            for(int j = 0 ; j < N ; j++){     // 90도 돌림
                for(int i = N-1 ; i >= 0 ; i--){
                        copy[ j ][(N-1) - i] = key[i][j];
                }
            }
        }else if(cnt == 2){
            for(int i = N-1 ; i >= 0 ; i--){    //  180 도   
                for(int j = N-1 ; j >= 0 ; j--){
                       copy[ (N-1) - i ][(N-1) - j] = key[i][j];
                }
            }
        }else if(cnt == 3){
            for(int j = N-1 ; j >= 0 ; j--){    // 270도
                for(int i = 0 ; i < N ; i++){
                        copy[(N-1) - j ][i] = key[i][j];
                }
            }
        }
        
        return copy;
        
        
        
        
    } 
}