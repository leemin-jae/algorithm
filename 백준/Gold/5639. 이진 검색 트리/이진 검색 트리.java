import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int x;
        Node left_child;
        Node right_child;
        public Node(int x){
            this.x = x;
        }
    }
    static List<Node> nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        if(s == null || s.equals("") ) System.exit(0);
        int first = Integer.parseInt(s);

        Node node = new Node(first);
        while(true){
            s = br.readLine();
            if( s == null || s.equals("")) break;
            int now = Integer.parseInt(s);
            create_tree(now,node);
        }

        search(node);

    }
    static public void search(Node now){
        if(now == null) return;

        search(now.left_child);
        search(now.right_child);
        System.out.println(now.x);
    }
    static public void create_tree(int num ,Node now){
        if(now.x > num){
            if(now.left_child == null){
                now.left_child = new Node(num);
            }else{
                create_tree(num, now.left_child);
            }
        }else{
            if(now.right_child == null){
                now.right_child = new Node(num);
            }else{
                create_tree(num, now.right_child);
            }
        }


    }

}