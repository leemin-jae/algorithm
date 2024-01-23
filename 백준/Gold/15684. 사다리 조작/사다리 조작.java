import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H, Min;
	static boolean Map[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		Min = Integer.MAX_VALUE;

		Map = new boolean[H + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			Map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}

		dfs(1, 0);

		System.out.println(Min == Integer.MAX_VALUE ? -1 : Min);

	}

	static public void dfs(int n, int cnt) {
		if (cnt > 3) {
			return;
		}
		if (isEnd()) {
			Min = Math.min(Min, cnt);
			return;
		}

		for (int i = n; i <= N; i++) {
			for (int j = 1; j <= H; j++) {
				if (!Map[j][i] && go(i, j)) {
					Map[j][i] = true;
					dfs(i, cnt + 1);
					Map[j][i] = false;
				}
			}
		}
	}

	static public boolean go(int i, int j) {
		if (i == 1) {
			return true;
		} else if (i == N) {
			return false;
		} else {
			if (Map[j][i - 1]) {
				return false;
			}
		}
		return true;
	}

	static public boolean isEnd() {
		for (int i = 1; i <= N; i++) {
			int x = i;
			for (int j = 1; j <= H; j++) {
				if (Map[j][x]) {
					x++;
				}else if (Map[j][x-1]) {
					x--;
				}
			}
			if (x != i) {
				return false;
			}
		}
		return true;
	}

}