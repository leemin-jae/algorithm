import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R, Map[][], check[][], cnt, cal[][];
	static int delta[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		Map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int sum = 0;
		while (true) {
			
			cnt = 1;
			check = new int[N][N];
			cal = new int[N*N+1][2];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}
			
			if(cnt == N*N+1) {
				break;
			}
			
			sum++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Map[i][j] = cal[check[i][j]][0]/cal[check[i][j]][1];
				}
			}
		}
		
		System.out.println(sum);

	}

	static public void bfs(int x, int y) {
		if (check[x][y] != 0) {
			return;
		}
		check[x][y] = cnt;
		cal[cnt][0] += Map[x][y];
		cal[cnt][1] ++;
		Queue<int[]> que = new LinkedList<>();

		que.add(new int[] { x, y });

		while (!que.isEmpty()) {
			int a[] = que.poll();
			int currentX = a[0];
			int currentY = a[1];

			for (int i = 0; i < 4; i++) {
				int nextX = currentX + delta[i][0];
				int nextY = currentY + delta[i][1];

				if (nextX < 0 || nextY >= N || nextY < 0 || nextX >= N || check[nextX][nextY] != 0)
					continue;
				if (Math.abs(Map[currentX][currentY] - Map[nextX][nextY]) >= L && Math.abs(Map[currentX][currentY] - Map[nextX][nextY]) <= R) {
					check[nextX][nextY] = cnt;
					cal[cnt][0] += Map[nextX][nextY];
					cal[cnt][1] ++;
					que.add(new int[] { nextX, nextY });
				}
			}

		}

		cnt++;

	}
}