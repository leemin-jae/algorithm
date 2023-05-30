import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Node implements Comparable<Node>{
        int deadLine;
        int cup;
        Node(int deadLine , int cup){
            this.deadLine = deadLine;
            this.cup = cup;
        }

        @Override
        public int compareTo(Node o) {
            if(o.deadLine == this.deadLine){
                return o.cup - this.cup;
            }
            return this.deadLine - o.deadLine;
        }
    }
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Node> arr = new ArrayList<>();

        for(int i = 0 ; i < N ;i++){
            st = new StringTokenizer(br.readLine());
            arr.add(new Node(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken())));
        }
        
        Collections.sort(arr);
        
        
        for(Node node : arr ){
            int size = queue.size();
            
            if(size < node.deadLine){
                queue.add(node.cup);
            }
            else if(size == node.deadLine){
                int peek = queue.peek();
                
                if(node.cup > peek){
                    queue.poll();
                    queue.add(node.cup);
                }
            }
            
            
        }
        int sum = 0;
        while (!queue.isEmpty()){
            sum += queue.poll();
        }

        System.out.println(sum);

    }



}