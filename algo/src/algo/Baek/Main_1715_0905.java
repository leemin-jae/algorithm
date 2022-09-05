package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main_1715_0905 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq =new PriorityQueue<Integer>();
		
		
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		//Arrays.sort(Map);
		int sum = 0;
		while(pq.size() != 1) {
			int a = pq.poll();
			int b = pq.poll();
			sum += a+b;
			pq.add(a+b);
		}
		System.out.println(sum);
		
	}

}
