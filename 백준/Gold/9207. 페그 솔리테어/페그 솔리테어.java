import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int delta[][] = {{1,0},{0,1},{-1,0},{0,-1}} , pin, move;
    static char Map[][];
    static boolean checked[][], checked_f[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());

        for(int T = 0 ; T <tc ; T++){

            Map = new char[5][9];
            checked = new boolean[5][9];
            pin = Integer.MAX_VALUE;
            move = Integer.MAX_VALUE;

            for(int i = 0 ; i < 5 ;i++){
                String s = br.readLine();
                for(int j = 0 ; j < 9 ; j++){
                    Map[i][j] = s.charAt(j);
                    if(Map[i][j] == '#'){
                        checked[i][j] = true;
                    }
                }
            }

            dfs(0, Map);

            System.out.println(pin + " " + move);
//            System.out.println("---------");
            br.readLine();


        }

    }
    public static void dfs(int cnt , char Map[][]){
        int sum = 0;
        for(int i = 0 ; i< 5 ; i++){
            for(int j = 0 ; j < 9 ; j++){

                if(Map[i][j] == 'o'){
                    sum++;
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + delta[k][0];
                        int nextY = j + delta[k][1];
                        if (nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 9 || checked[nextX][nextY] || Map[nextX][nextY] != 'o')
                            continue;
                        int jumpX = nextX + delta[k][0];
                        int jumpY = nextY + delta[k][1];
                        if(jumpX < 0 || jumpX >= 5 || jumpY < 0 || jumpY >= 9 || checked[jumpX][jumpY] || Map[jumpX][jumpY] != '.')
                            continue;
                        char nextMap[][] = copy(Map);
                        nextMap[i][j] = '.';
                        nextMap[nextX][nextY] = '.';
                        nextMap[jumpX][jumpY] = 'o';
                        dfs(cnt+1, nextMap);
                    }
                }
            }
        }

//        System.out.println(sum + " " + cnt);
        if(sum < pin){
            pin = sum;
            move = cnt;
        }else if(sum == pin && move < cnt){
            move = cnt;
        }
    }
    public static char[][] copy(char [][] Map){
        char[][]copy = new char[5][9];
        for(int i = 0 ; i < 5 ;i++){
            for(int j = 0 ; j < 9 ; j++){
                copy[i][j] = Map[i][j];
            }
        }
        return copy;
    }

}