import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = -1;
        for(int i = 0 ; i < N ;i++){
            String s = br.readLine();
            switch (s.charAt(0)){
                case 'p':
                    if(s.equals("pop")){
                        if(!queue.isEmpty()){
                            System.out.println(queue.poll());
                        }else{
                            System.out.println(-1);
                        }
                    }else{
                        int now = Integer.parseInt(s.split(" ")[1]);
                        queue.add(now);
                        last = now;
                    }
                    break;
                case 's':
                    System.out.println(queue.size());
                    break;
                case 'e' :
                    if(!queue.isEmpty()){
                        System.out.println(0);
                    }else{
                        System.out.println(1);
                    }
                    break;
                case 'f' :
                    System.out.println(queue.isEmpty()?-1:queue.peek());
                    break;
                case 'b' :
                    System.out.println(queue.isEmpty()?-1:last);
                    break;
            }
        }

    }


}