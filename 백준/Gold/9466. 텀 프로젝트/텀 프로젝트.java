import java.util.*;

    public class Main {
        static boolean visited[],finished[];
        static int choices[], count;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt(); // 테스트 케이스 수 입력

            for (int i = 0; i < t; i++) {
                int n = sc.nextInt(); // 학생 수 입력
                choices = new int[n + 1]; // 선택된 학생 번호를 저장할 배열
                count = 0;

                visited = new boolean[n + 1];
                finished = new boolean[n + 1];

                // 선택된 학생 번호 입력 및 팀 배열 초기화
                for (int j = 1; j <= n; j++) {
                    choices[j] = sc.nextInt();
                }


                for (int j = 1; j <= n; j++) {
                    dfs(j);
                }

                System.out.println(n - count);

            }
            sc.close();
        }
        static void dfs(int now){
            if(visited[now]) return;

            visited[now] = true;
            int next = choices[now];


            if(!visited[next]){
                dfs(next);
            }else{
                if(!finished[next]){
                    count++;
                    for(int i = next ; i != now ; i = choices[i]){
                        count++;
                    }
                }
            }

            finished[now] = true;

        }
    }