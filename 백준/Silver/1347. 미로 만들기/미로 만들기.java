import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int delta[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean checked[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N == 0){
            System.out.println(".");
            return;
        }
        String s = br.readLine();

        checked = new boolean[151][151];

        int cnt = 0;

        int x = 50;
        int y = 50;
        checked[x][y] = true;
        int max_x = 50;
        int max_y = 50;
        int min_x = 50;
        int min_y = 50;

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == 'R'){
                cnt = cnt-1>=0? cnt-1:3;
            }else if(s.charAt(i) == 'L'){
                cnt = (cnt+1)%4;
            }else{
                x += delta[cnt][0];
                y += delta[cnt][1];
                checked[x][y] = true;
                max_x = Math.max(max_x,x);
                min_x = Math.min(min_x,x);
                max_y = Math.max(max_y, y);
                min_y = Math.min(min_y,y);
            }
            
        }

        for(int i = min_x; i <= max_x ; i++){
            for(int j= min_y; j <= max_y ; j++){
                if(checked[i][j]){
                    System.out.print(".");
                }else{
                    System.out.print("#");
                }
            }
            System.out.println();
        }

    }

}