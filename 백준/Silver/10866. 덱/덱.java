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
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0 ; i < N ;i++){
            String s = br.readLine();
            switch (s.charAt(0)){
                case 'p':
                    if(s.charAt(1) == 'o'){
                        if(s.equals("pop_front")){
                            System.out.println(deque.isEmpty()?-1:deque.pollFirst());
                        }else{
                            System.out.println(deque.isEmpty()?-1:deque.pollLast());
                        }
                    }else{
                        String now[] = s.split(" ");
                        if(now[0].equals("push_front")){
                            deque.addFirst(Integer.parseInt(now[1]));
                        }else{
                            deque.addLast(Integer.parseInt(now[1]));
                        }
                    }
                    break;
                case 's':
                    System.out.println(deque.size());
                    break;
                case 'e' :
                    if(!deque.isEmpty()){
                        System.out.println(0);
                    }else{
                        System.out.println(1);
                    }
                    break;
                case 'f' :
                    System.out.println(deque.isEmpty()?-1:deque.peekFirst());
                    break;
                case 'b' :
                    System.out.println(deque.isEmpty()?-1:deque.peekLast());
                    break;
            }
        }

    }


}