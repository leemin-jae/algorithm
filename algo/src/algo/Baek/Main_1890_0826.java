package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1890_0826 {
	static int N, Map[][], cnt;
	static int delta[][] = {{0,1},{1,0}};
	static long isCheck[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		cnt = 0;
		
		Map = new int[N][N];
		isCheck = new long[N][N];
		
		for(int i = 0 ; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		isCheck[0][0] = 1;
		
		for(int i = 0 ; i < N;i++) {
			for (int j = 0; j < N; j++) {
				
				if(isCheck[i][j] == 0 || Map[i][j] == 0) continue;
				
				for (int k = 0; k < 2; k++) {
					int nextX = i + delta[k][0]*Map[i][j];
					int nextY = j + delta[k][1]*Map[i][j];
					
					if(nextX >= N || nextY >= N) continue;
					
					isCheck[nextX][nextY] += isCheck[i][j];
					
				}
			}
		}
		
		//DFS(0,0);
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(isCheck[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(isCheck[N-1][N-1]);
	}
	
//	static public void DFS(int x , int y) {
//		if(x == N-1 && y == N-1) {
//			cnt++;
//			return;
//		}
//		for (int i = 0; i < 2; i++) {
//			int nextX = x + delta[i][0]*Map[x][y];
//			int nextY = y + delta[i][1]*Map[x][y];
//			
//			if(nextX >= N || nextY >= N) continue;
//			isCheck[nextX][nextY] = isCheck[nextX][nextY] + isCheck[x][y];
//			DFS(nextX,nextY);
//		}
//		
//		
//	}
}
