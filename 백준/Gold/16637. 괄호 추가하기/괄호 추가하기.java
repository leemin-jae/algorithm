import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N , Max ;
    static String s;
    public static void main (String[]args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Max = Integer.MIN_VALUE;

        s = br.readLine();
        if(s.length() == 1){
            System.out.println(s.charAt(0) -'0');
        }else{
            dfs(1 , s.charAt(0) -'0' ,"1");
            dfs(3 , calculate(s.charAt(0) - '0' , s.charAt(1) , s.charAt(2) -'0') , "2");
            System.out.println(Max);
        }

    }

    static public void dfs(int cnt , int sum , String sk){
        if(cnt >= s.length()){
            Max = Math.max(Max , sum);
            return;
        }

        char cal = s.charAt(cnt);
        int first = s.charAt(cnt+1) - '0';

        dfs(cnt+2 , calculate(sum , cal , first) ,sk +"1");


        if(cnt + 3 < s.length()){
            char secondCal = s.charAt(cnt+2);
            int second = s.charAt(cnt+3) - '0';

            dfs(cnt+4 , calculate(sum , cal , calculate(first , secondCal , second)),sk +"2");
        }

    }

    static public int calculate(int first , char cal , int second){
        switch (cal){
            case '+':
                return first+second;
            case '-':
                return first-second;
            case '*':
                return first*second;
        }
        return 0;
    }
}