package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1449_0904 {
	static int N, L;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int pipe[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ;i ++) {
			pipe[i] = Integer.parseInt(st.nextToken());
		}
			
		Arrays.sort(pipe);
		int sum = 0;
		int now = -99999;
		for (int i = 0; i < pipe.length; i++) {
			if(now < pipe[i]) {
				now = pipe[i] + (L-1);
				sum++;
			}
		}
		
		System.out.println(sum);
		
			
	}

}
