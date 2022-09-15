package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_0915 {
	static int M, N, H, F, Min;
	static int Map[][][],
			delta[][] = { { 1, 0, 0 }, { 0, 1, 0 }, { -1, 0, 0 }, { 0, -1, 0 }, { 0, 0, -1 }, { 0, 0, 1 } };
	static boolean check[][][];
	static Queue<int[]> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		F = M * N * H;
		Min = Integer.MIN_VALUE;
		Map = new int[N][M][H];
		check = new boolean[N][M][H];

		for (int h = 0; h < H; h++) {

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					Map[i][j][h] = Integer.parseInt(st.nextToken());
					if (Map[i][j][h] == 1) {
						que.add(new int[] { i, j, h, 0 });
						check[i][j][h] = true;
					}
					if (Map[i][j][h] == -1) {
						F--;
					}
				}
			}

		}
		
		BFS();
		
		if(F == 0) {
			System.out.println(Min);
		}else {
			System.out.println(-1);
		}

	}

	public static void BFS() {
		while (!que.isEmpty()) {

			int now[] = que.poll();
			int n = now[0];
			int m = now[1];
			int h = now[2];
			int day = now[3];
			F--;
			Min = Math.max(Min, day);

			for (int i = 0; i < 6; i++) {
				int nextN = n + delta[i][0];
				int nextM = m + delta[i][1];
				int nextH = h + delta[i][2];

				if (nextN < 0 || nextN >= N || nextM < 0 || nextM >= M || nextH < 0 || nextH >= H)
					continue;

				if (check[nextN][nextM][nextH] || Map[nextN][nextM][nextH] == -1)
					continue;

				que.add(new int[] { nextN, nextM, nextH, day + 1 });
				check[nextN][nextM][nextH] = true;

			}

		}
	}

}
