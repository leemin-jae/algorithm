import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        String s = null;
        while (!(s = br.readLine()).equals("0")){
            st = new StringTokenizer(s);
            N = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            while (st.hasMoreTokens()){
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);
            int size = list.size();
            int map[] = new int[size];
            for(int i= 0 ; i < size ;i++){
                map[i] = list.get(i);
            }
            function(0,0,new boolean[list.size()], map);

            System.out.println();
        }
    }

    static public void function(int cnt, int check, boolean checked[], int map[]){
        if(cnt == map.length){
            if(check == 6){
                for(int i = 0 ; i < checked.length; i++){
                    if(checked[i]) {
                        System.out.print(map[i] + " ");
                    }
                }
                System.out.println();
            }
            return;
        }

        checked[cnt] = true;
        function(cnt + 1, check+1, checked, map);
        checked[cnt] = false;
        function(cnt + 1, check, checked, map);

    }

}