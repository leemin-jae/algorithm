import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {
        static boolean visited[],finished[];
        static int choices[], count;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> right = new PriorityQueue<>();
            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < N ;i++){
                int x = Integer.parseInt(br.readLine());

                if(left.isEmpty() || left.peek() >= x){
                    left.add(x);
                }else{
                    right.add(x);
                }

                if(right.size() > left.size()){    // 0 : 1 // 1 : 1 // 2 : 1 - > 1 : 2 / 2: 2// 3 : 2 -> 2 : 3
                    left.add(right.poll());
                }else if(right.size()+ 1< left.size()){  // 0 : 1 //  0 : 2  ->  1 : 1 // 1 : 2 // 1 : 3
                    right.add(left.poll());
                }
                sb.append(left.peek() + "\n");

            }

            System.out.println(sb);

        }
    }