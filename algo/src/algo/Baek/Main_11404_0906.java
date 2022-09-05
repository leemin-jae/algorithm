package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11404_0906 {
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		int adjMatrix[][] = new int[N + 1][N + 1];
		int INF = 987654321;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				adjMatrix[i][j] = INF;
				if (i == j) {
					adjMatrix[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());

			adjMatrix[from][to] = Math.min(adjMatrix[from][to], wei);

		}

		for (int k = 1; k <= N; ++k) { // k = 거쳐가는 노드 , i = 출발 노드, j = 도착 노드
			for (int i = 1; i <= N; ++i) {
				if (i == k)
					continue;

				for (int j = 1; j <= N; ++j) {
					if (i == j || k == j)
						continue;

					if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
					}
				}
			}
		}

		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				if (adjMatrix[i][j] == INF) {
					adjMatrix[i][j] = 0;
				} 
					System.out.print(adjMatrix[i][j] + " ");

				
			}
			System.out.println();
		}
	}

}
