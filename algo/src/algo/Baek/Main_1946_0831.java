package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1946_0831 {
	static int T, N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 0 ; tc < T ; tc++) {
			
			N = Integer.parseInt(br.readLine());
			if(N == 0) {
				sb.append(0).append("\n");
				continue;
			}
			List<int []> list = new ArrayList<>();
			
			for(int i = 0 ; i < N ;i ++) {
				st = new StringTokenizer(br.readLine());
				
				list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			Collections.sort(list, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
				
			});
			
			
			for(int a[] : list) {
				System.out.println(a[0]  + " " + a[1]);
			}
			int sum = 0 ;
			int max_num = list.get(0)[1];
			for(int i = 0 ; i < N; i++) {
				int now[] = list.get(i);
				if(now[1] <= max_num) {
					sum++;
					max_num = now[1];
				}
				
			}
			
			sb.append(sum).append("\n");
			
		}
		
		System.out.println(sb);
	}

}
