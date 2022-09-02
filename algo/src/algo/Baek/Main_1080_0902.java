package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1080_0902 {
	static int N,M;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		
		int Map[][] = new int[N][M];
		int goal[][] = new int[N][M];
		for(int i = 0 ; i < N  ;i++) {
			String in = br.readLine();
			for(int j = 0 ;  j < M ; j++) {
				Map[i][j] = in.charAt(j) -'0';
			}
		}
		
		for(int i = 0 ; i < N  ;i++) {
			String in = br.readLine();
			for(int j = 0 ;  j < M ; j++) {
				goal[i][j] = in.charAt(j) -'0';
			}
		}
		int sum = 0;
		
		if(N < 3 ||  M  < 3) {
			boolean ch = false;
			for(int i = 0 ; i < N ; i ++) {
				for(int j = 0 ; j < M ; j++) {
					if(Map[i][j] != goal[i][j]) {
						ch = true;
						break;
					}
				}
				
				if(ch) {
					break;
				}
			}
			
			if(ch) {
				sum = -1;
			}
		}
		for(int i = 0 ; i <= N-3; i++) {
			for(int j = 0 ; j <= M-3 ; j++) {
				
				if(Map[i][j] == goal[i][j]) {
					continue;
				}else {
					sum ++;
					for(int k = 0  ; k < 3 ; k++) {
						Map[i][j+k] = Math.abs(Map[i][j+k] -1);
						Map[i+1][j+k] = Math.abs(Map[i+1][j+k] -1);
						Map[i+2][j+k] = Math.abs(Map[i+2][j+k] -1);
						
						
					}
					
				}
				
			}
			
			
		}
		
		
		boolean ch = false;
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j++) {
				if(Map[i][j] != goal[i][j]) {
					ch = true;
					break;
				}
			}
			
			if(ch) {
				break;
			}
		}
		
		if(ch) {
			sum = -1;
		}
		
		System.out.println(sum);
		
		
	}

}
