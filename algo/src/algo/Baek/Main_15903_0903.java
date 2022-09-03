package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15903_0903 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int Card[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Card[i] = Integer.parseInt(st.nextToken());
		}

		
		for (int tc = 0; tc < M; tc++) {
			Arrays.sort(Card);
		
			
		
				int num = Card[0] + Card[1];
				Card[0] = num;
				Card[1] = num;

			
		}
		
		int sum = 0;
		for(int i = 0 ; i <  N ;i ++) {
			sum += Card[i];
		}
		
		System.out.println(sum);
		
		

	}

}
