package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_2606_0827 {
	static int N, M,cnt;
	static boolean isCheck[];
	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
		
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		cnt = 0;
		Node [] node = new Node[N+1];
		isCheck = new boolean[N+1];
		
		
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			node[from] = new Node(to , node[from]);
			node[to] = new Node(from, node[to]);
			
		}
		
		for(Node n : node) {
			//System.out.println(n);
		}
		
		//System.out.println(node[1].link);
		
		Queue<Integer> que = new LinkedList<>();
		que.offer(1);
		isCheck[1] = true;
		
		while(!que.isEmpty()) {
			
			int current = que.poll();

			
			
			for(Node temp = node[current] ; temp != null ; temp = temp.link) {
				if(!isCheck[temp.vertex]) {
					que.offer(temp.vertex);
					isCheck[temp.vertex] = true;
					cnt++;
				}
			}
			
			
		}
		//test 변경
		System.out.println(cnt);
		
		
		
	}

}
