import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int delta[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    static class Node{
        int x;
        int y;
        int dis;
        Node(int x, int y,int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int Map[][] = new int [N][M];
        int result[][] = new int[N][M];
        boolean visited[][] = new boolean[N][M];

        Node node = null;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                result[i][j] = -1;
                Map[i][j] = Integer.parseInt(st.nextToken());
                if(Map[i][j] == 2){
                    node = new Node(i,j,0);
                }
            }
        }

        Queue<Node> que = new LinkedList<>();
        que.add(node);
        visited[node.x][node.y] = true;
        result[node.x][node.y] = 0;

        while(!que.isEmpty()){

            Node now = que.poll();
            result[now.x][now.y] = now.dis;

            for(int i = 0 ; i <  4 ; i++){
                int nextX = now.x + delta[i][0];
                int nextY = now.y + delta[i][1];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(Map[nextX][nextY] == 0 || visited[nextX][nextY]) continue;

                que.add(new Node(nextX, nextY, now.dis +1 ));
                visited[nextX][nextY] = true;
            }


        }
        for(int i = 0 ; i < N ; i++){

            for(int j = 0 ; j < M ; j++){

                if(Map[i][j] == 0) result[i][j] = 0;

            }
        }

        for(int i = 0 ; i < N ; i++){

            for(int j = 0 ; j < M ; j++){


                    System.out.print(result[i][j] + " ");

            }
            System.out.println();
        }








    }
}