package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2251_0828 {
	static int A,B,C;
	static boolean isCheck[][][];
	static boolean isC[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());

		B = Integer.parseInt(st.nextToken());

		C = Integer.parseInt(st.nextToken());
		isCheck = new boolean[A+1][B+1][C+1];
		isC = new boolean[C+1];
		
		BFS(0,0,C);
		
		for(int i = 0 ; i <= C ; i++) {
			if(isC[i]) {
				System.out.print(i + " ");
			}
		}
		
		
	}
	
	static public void BFS(int a, int b, int c) {
		if(isCheck[a][b][c]) return;
		isCheck[a][b][c] = true;
		if(a== 0) {
			isC[c] = true;
		}
		
		// (A-a) , (B-b) , (C-c)  통 마다 들어갈수 있는 양
		// C에서 A로 이동 -> (A-a) >= c  [a+c][b][0]  /   (A-a) < c  [A][b][c-(A-a)]
		if(A-a >= c) {
			BFS(a+c,b,0);
		}else {
			BFS(A,b,c-(A-a));
		}
		
		
		if(B-b >= c) {
			BFS(a,b+c,0);
		}else {
			BFS(a,B,c-(B-b));
		}
		
		//////
		
		if(A-a >= b) {
			BFS(a+b,0,c);
		}else {
			BFS(A,b-(A-a),c);
		}
		
		if(C-c >= b) {
			BFS(a,0,c+b);
		}else {
			BFS(a,b-(C-c),C);
		}
		
		
		//////
		
		if(B-b >= a) {
			BFS(0,b+a,c);
		}else {
			BFS(a-(B-b),B,c);
		}
		
		if(C-c >= a) {
			BFS(0,b,c+a);
		}else {
			BFS(a-(C-c),b,C);
		}
		
		
		
		
		
		
		
	}

}
