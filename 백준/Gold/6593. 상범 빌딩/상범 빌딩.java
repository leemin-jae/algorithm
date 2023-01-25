import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int x;
        int y;
        int z;
        int time;
        Node(int z,int x, int y ,int time){
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }
    }
    static char Map[][][];
    static boolean visited[][][];
    static int delta[][] = {{0,1,0},{0,0,1},{0,-1,0},{0,0,-1},{1,0,0},{-1,0,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(L*R*C == 0) break;

            Map = new char[L][R][C];
            visited = new boolean[L][R][C];
            Queue<Node> que = new LinkedList<>();
            int Min = Integer.MAX_VALUE;

            for(int i = 0 ; i < L ; i++){
                for(int j = 0 ; j < R ; j++){
                    String s = br.readLine();
                    for(int k = 0 ; k < C ; k++){
                        Map[i][j][k] = s.charAt(k);
                        if(Map[i][j][k] == 'S'){
                            que.add(new Node(i,j,k,0));
                            visited[i][j][k] = true;
                        }
                    }
                }
                br.readLine();
            }

            while (!que.isEmpty()){

                Node now = que.poll();
                if(Map[now.z][now.x][now.y] == 'E'){
                    Min = now.time;
                    break;
                }

                for(int i = 0 ; i < 6; i++){
                    int x = now.x + delta[i][1];
                    int y = now.y + delta[i][2];
                    int z = now.z + delta[i][0];

                    if(x < 0 || y < 0 || z < 0 || x >= R || y >= C || z >= L) continue;
                    if(visited[z][x][y] || Map[z][x][y] == '#') continue;

                    que.add(new Node(z,x,y, now.time+1));
                    visited[z][x][y] = true;
                }
            }

            if(Min == Integer.MAX_VALUE){
                System.out.println("Trapped!");
            }else{
                System.out.println("Escaped in "+ Min +" minute(s).");
            }




        }


    }
}