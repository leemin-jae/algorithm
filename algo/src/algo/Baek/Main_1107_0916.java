package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1107_0916 {
	static boolean check[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		check = new boolean[10];

		String N = br.readLine();
		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			check[Integer.parseInt(st.nextToken())] = true;
		}
		
		for(int i = 0 ; i < N.length(); i++) {
			
		}
		
	}
	
	static public int BFS(int n) {
		if(!check[n]) {
			return n;
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		boolean ch[] = new boolean[10];
		que.add(n);
		
		
		
		
		return 1;
	}

}
