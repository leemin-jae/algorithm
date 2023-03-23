import java.io.*;
import java.util.*;


public class Main {
    static class Node implements Comparable<Node>{
        int num;
        int abs;
        Node(int num){
            this.num = num;
            this.abs = Math.abs(num);
        }

        @Override
        public int compareTo(Node o) {
             if(this.abs == o.abs){
                          return this.num - o.num;
                     }else{
                         return this.abs - o.abs;
             }
        }



    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));




        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> queue = new PriorityQueue<>();


        for(int i = 0 ; i< N ; i++){
            int now = Integer.parseInt(br.readLine());
            if(now == 0){
                if(queue.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(queue.poll().num);
                }

            }else{
                queue.add(new Node(now));
            }

        }



    }

}