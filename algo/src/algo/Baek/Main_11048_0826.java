package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11048_0826 {
	static int N,M, Map[][], DP[][];
	static int delta[][] = {{0,1},{1,0},{1,1}};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map = new int[N][M];
		DP = new int[N][M];
		for(int i = 0 ; i < N ;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DP[0][0] = Map[0][0];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ;j++) {
				int x = i;
				int y = j;
				for(int k = 0 ; k < 3 ; k++) {
					int nextX = x+delta[k][0];
					int nextY = y+delta[k][1];
					
					if(nextX >= N || nextY >= M) continue;
					
					DP[nextX][nextY] = DP[nextX][nextY] < DP[i][j] + Map[nextX][nextY] ? DP[i][j] + Map[nextX][nextY] : DP[nextX][nextY];
					
				}
				
			}
		}
		
		
		System.out.println(DP[N-1][M-1]);
		
	}
	
	

}
