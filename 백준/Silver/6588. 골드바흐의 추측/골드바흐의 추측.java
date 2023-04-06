import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {
        static boolean visited[],finished[];
        static int choices[], count;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            boolean checked[] = new boolean[1000001];
            checked[0] = true;
            checked[1] = true;
            for(int i = 2; i <= 1000000 ; i++){
                if(!checked[i]){
                    int j = 2;
                    while(i*j <= 1000000){
                        checked[i*j] = true;
                        j++;
                    }
                }
            }

            while(true){
                int x = Integer.parseInt(br.readLine());
                if(x == 0) break;
                boolean flag = false;

                for(int i = 2 ; i <= x ; i++){
                    if(checked[i] || checked[x-i]) continue;
                    System.out.println(x + " = " + i + " + " + (x-i));
                    flag = true;
                    break;
                }

                if(!flag){
                    System.out.println("Goldbach's conjecture is wrong.");
                }

            }


        }
    }