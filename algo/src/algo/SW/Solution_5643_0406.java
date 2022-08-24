package algo.SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_5643_0406 {
	static final int INF = 9999;
	static int N, M, adjMatrix[][];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			adjMatrix = new int[N + 1][N + 1];

			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());

				adjMatrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;

			}

			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					if (i != j && adjMatrix[i][j] == 0) {// ?žê¸°ìž?‹ ?œ¼ë¡œì˜ ?¸? ‘ ? •ë³´ê? ?•„?‹ˆê³? ?¸? ‘?•´?žˆì§? ?•Š?‹¤ë©? INFë¡? ì±„ìš°ê¸?
						adjMatrix[i][j] = INF;
					}
				}
			}

			for (int k = 1; k <= N; ++k) {
				for (int i = 1; i <= N; ++i) {
					if (i == k)
						continue; // ì¶œë°œì§??? ê²½ìœ ì§?ê°? ê°™ë‹¤ë©? ?‹¤?Œ ì¶œë°œì§?
					for (int j = 1; j <= N; ++j) {
						if (i == j || k == j)
							continue; // ê²½ìœ ì§??? ëª©ì ì§?ê°? ê°™ê±°?‚˜ ì¶œë°œì§?ê°? ê³? ëª©ì ì§??¼ë©? ?Œ¨?Š¤
						// ê°„ì„ ?´ ?–‘?ˆ˜?´ë©?...
						if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
							adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
						}
					}
				}
			}

//			
//			for(int i=1; i<=N; ++i) {
//				for(int j=1; j<=N; ++j) {
//					System.out.print(adjMatrix[i][j]+"\t");
//				}
//				System.out.println();
//			}
//			System.out.println("=====================================");
//			

			int cnt[] = new int[N + 1];

			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					if(adjMatrix[i][j] < 1000 &&  adjMatrix[i][j] != 0) {
						cnt[j]++;
						cnt[i]++;
					}
				}
			}
			
			
			
			int sum = 0;
			
			for(int i = 1; i <= N; i++) {
				if(cnt[i] == N-1) sum++;
				//System.out.print(cnt[i] + " ");
			}
			
			System.out.println("#" + tc + " " + sum);

		}

	}

}
