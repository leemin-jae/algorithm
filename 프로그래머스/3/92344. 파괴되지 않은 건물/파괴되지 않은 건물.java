class Solution {
    public int solution(int[][] board, int[][] skill) {

        int sumBoard[][] =new int[board.length+1][board[0].length+1];

        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];

            if(type == 1){
                degree = -degree;
            }

            sumBoard[r1][c1] += degree;
            sumBoard[r2+1][c2+1] += degree;
            sumBoard[r2+1][c1] += -degree;
            sumBoard[r1][c2+1] += -degree;

        }
        
//                         for (int i = 0; i <= board.length; i++) {
//             for (int j = 0; j <= board[0].length; j++) {
//                 System.out.print(sumBoard[i][j]+ "\t");
//             }
//             System.out.println();
//         }
        
//          System.out.println("========");



        for (int i = 1; i <= board.length; i++) {
            for (int j = 0; j <= board[0].length; j++) {
                sumBoard[i][j] += sumBoard[i-1][j];
            }
        }

        for (int j = 1; j <= board[0].length; j++) {
            for (int i = 0; i <= board.length; i++) {
                sumBoard[i][j] += sumBoard[i][j-1];
            }
        }
        








        int answer= 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] + sumBoard[i][j];
                if(board[i][j]> 0){
                    
                    answer++;
                }
            }
        }
        
        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board[0].length; j++) {
        //         System.out.print(board[i][j]+ " ");
        //     }
        //     System.out.println();
        // }



        return answer;
    }
}