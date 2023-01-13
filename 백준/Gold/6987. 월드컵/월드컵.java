import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int win[] , lose[] , draw[];
    static boolean flag;

    static boolean check[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        win = new int[6];
        lose = new int[6];
        draw = new int[6];

        for(int tc = 0 ; tc < 4; tc++){
            int sum = 0;
            st = new StringTokenizer(br.readLine());

            for(int i = 0 ; i < 6 ; i++){
                sum+=win[i] = Integer.parseInt(st.nextToken());
                sum+=draw[i] = Integer.parseInt(st.nextToken());
                sum+=lose[i] = Integer.parseInt(st.nextToken());
            }

            flag = false;

            if(sum == 30){
                ch(0,0,1);
            }
            System.out.print((flag == false? "0":"1") + " ");

        }
    }
    static public void ch(int team, int cnt , int index){
       if(flag) return;
        if(win[team] < 0 || lose[team] < 0 || draw[team] < 0 || win[team + index - 1] < 0 || lose[team + index - 1] < 0 || draw[team + index - 1] < 0 ) return;
       if(cnt == 15){
           flag =true;
           return;
       }

       if(cnt == 5){
            team++;
            index = 1;
       }else if(cnt == 9){
            team++;
            index = 1;
       }else if(cnt == 12){
           team++;
           index = 1;
       }else if(cnt == 14){
           team++;
           index = 1;
       }
        //a가 이기고 b가 질때
        win[team]--;
        lose[team+index]--;
        ch(team,cnt+1,index+1);
        win[team]++;
        lose[team+index]++;
        //a가 지고 b가 이길때
        win[team+index]--;
        lose[team]--;
        ch(team,cnt+1,index+1);
        win[team+index]++;
        lose[team]++;
        //무승부일때
        draw[team]--;
        draw[team+index]--;
        ch(team,cnt+1,index+1);
        draw[team]++;
        draw[team+index]++;
    }
}