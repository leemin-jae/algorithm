import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int Map[] , c;
    static boolean checked[];
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        Map = new int[12];
        checked = new boolean[13];
        c = 0;
        int cnt = 0;
        for(int i = 0 ; i < 5 ; i++){
            String s = br.readLine();
            if(i == 0 || i == 4){
                if(s.charAt(4) != 'x'){
                    Map[cnt] = s.charAt(4) - 'A' +1;
                    checked[Map[cnt]] = true;
                }
                cnt++;
            }else if(i == 1 || i == 3){
                for(int j = 1; j < s.length() ; j+=2){
                    if(s.charAt(j) != 'x'){
                        Map[cnt] = s.charAt(j) - 'A' +1;
                        checked[Map[cnt]] = true;
                    }
                    cnt++;
                }
            }else {
                if(s.charAt(2) != 'x'){
                    Map[cnt] = s.charAt(2) - 'A' +1;
                    checked[Map[cnt]] = true;
                }
                cnt++;
                if(s.charAt(6) != 'x'){
                    Map[cnt] = s.charAt(6) - 'A' +1;
                    checked[Map[cnt]] = true;
                }
                cnt++;
            }
        }
        //1 + 2 + 3 + 4 / 7 +8 + 9 + 10 / 0 + 2 + 5 + 7 / 4 + 6 + 9 + 11 / 0 + 3 + 6 + 10 / 1 + 5 + 8 + 11
        dfs(0);

        String now[] = list.get(0).split(" ");

        String result = "...."+ Character.toString( Integer.parseInt(now[0]) + 'A' -1) +  "....\n" +
                "."+ Character.toString( Integer.parseInt(now[1]) + 'A' - 1) + "."+ Character.toString( Integer.parseInt(now[2]) + 'A' - 1) +  "." + Character.toString( Integer.parseInt(now[3]) + 'A' - 1) + "."+ Character.toString( Integer.parseInt(now[4]) + 'A' - 1) +  ".\n" +
                ".."+ Character.toString( Integer.parseInt(now[5]) + 'A' - 1) + "..."+ Character.toString( Integer.parseInt(now[6]) + 'A' - 1) + "..\n" +
                "."+ Character.toString( Integer.parseInt(now[7]) + 'A' - 1) + "."+ Character.toString( Integer.parseInt(now[8]) + 'A' - 1) +  "." + Character.toString( Integer.parseInt(now[9]) + 'A' - 1) + "."+ Character.toString( Integer.parseInt(now[10]) + 'A'- 1) +  ".\n" +
                "...."+ Character.toString( Integer.parseInt(now[11]) + 'A' - 1) +  "...." ;

        System.out.println(result);




    }

    static public void dfs(int cnt){
        if(list.size() != 0) return;
        if(cnt == 12){
            if(Map[1] + Map[2] + Map[3] + Map[4] == 26 && Map[7] + Map[8] + Map[9] + Map[10] == 26 && Map[0] + Map[2] + Map[5] + Map[7] == 26 && Map[4] + Map[6] + Map[9] + Map[11] == 26 &&
                    Map[0] + Map[3] + Map[6] + Map[10] == 26 && Map[1] + Map[5] + Map[8] + Map[11] == 26 ){
                String s = "";
                for(int i = 0 ; i < 12 ; i++){
                    s += Integer.toString(Map[i]) + " ";
                }
               
                list.add(s);
            }
            return;
        }
        if(Map[cnt] != 0){
            dfs(cnt+1);
        }else {
            for (int i = 1; i <= 12; i++) {
                if (!checked[i]) {
                    checked[i] = true;
                    Map[cnt] = i;
                    dfs(cnt + 1);
                    Map[cnt] = 0;
                    checked[i] = false;
                }
            }
        }

    }
}