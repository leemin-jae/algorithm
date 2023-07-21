import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N , Min, Max, M;

    static int delta[][] = {{0,1},{0,-1},{1,0},{-1,0}};

    static int Map[][];
    static int visited[][][];

    static class Node{
        int x;
        int cnt;
        Node list;

        Node(int x , int cnt){
            this.x = x;
            this.cnt = cnt;
        }

    }
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean visited[] = new boolean[K < N?2*N+1:2*K+1];


        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));
        visited[N] = true;

        while (!queue.isEmpty()){

            Node now = queue.poll();

            if(now.x == K){
                System.out.println(now.cnt);
                StringBuffer sb = new StringBuffer();
                List<Integer> l = new ArrayList<>();

                for(Node i = now;i.list != null; i = i.list){
                    l.add(i.x);
                }
                l.add(N);
                for(int i = l.size()-1 ; i >= 0 ; i--){
                    System.out.print(l.get(i) + " ");
                }
                break;
            }

            int plus = now.x + 1;
            int minus = now.x -1;
            int dou = now.x*2;

            if(plus <= K && !visited[plus]){
                Node p = new Node(plus, now.cnt+1);
                p.list = now;
                queue.add(p);
                visited[plus] = true;

            }

            if(minus >= 0 && !visited[minus]){
                Node m = new Node(minus, now.cnt+1);
                m.list = now;
                queue.add(m);
                visited[minus] = true;
            }

            if(dou <= K*2 && !visited[dou]){
                Node d = new Node(dou, now.cnt+1);
                d.list = now;
                queue.add(d);
                visited[dou] = true;
            }


        }



    }

}