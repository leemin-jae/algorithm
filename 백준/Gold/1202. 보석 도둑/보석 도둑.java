import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {
        static class Node{
            public int weight;
            public int price;

            Node(int weight , int price ){
                this.weight = weight;
                this.price = price;
            }

        }
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Node[] nodes = new Node[N];

            for(int i = 0 ; i < N ;i++){
                st = new StringTokenizer(br.readLine());
                nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(nodes, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.weight == o2.weight ?  o2.price - o1.price : o1.weight - o2.weight;
                }
            });

            int bag[] = new int[K];
            for(int i = 0 ; i < K ; i++){
                bag[i] = Integer.parseInt(br.readLine());

            }

            Arrays.sort(bag);

            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            long sum = 0;

            for(int i = 0 , j = 0 ; i< K ; i++){
                while (j < N && nodes[j].weight <= bag[i]){
                    queue.offer(nodes[j++].price);
                }

                if(!queue.isEmpty()){
                    sum += queue.poll();
                }

            }

            System.out.println(sum);


        }



    }