import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int cctv[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
//	static int cctvOne[][][] = { { { 0, 1 } }, { { 1, 0 } }, { { -1, 0 } }, { { 0, -1 } } };
//	static int cctvTwo[][][] = { { { 0, 1 }, { 0, -1 } }, { { 1, 0 }, { -1, 0 } } };
//	static int Three[][][] = { { { -1, 0 }, { 0, 1 } }, { { 0, 1 }, { 1, 0 } }, { { -1, 0 }, { 1, 0 } },
//			{ { -1, 0 }, { 0, -1 } } };
//	static int Four[][][] = { { { 0, 1 }, { 1, 0 }, { 0, -1 } }, { { -1, 0 }, { 1, 0 }, { 0, -1 } },
//			{ { -1, 0 }, { 0, 1 }, { 0, -1 } }, { { -1, 0 }, { 0, 1 }, { 1, 0 } } };
//	static int five[][][] = { { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } } };
//
//	static int cctv[][][][] = { {}, { { { 0, 1 } }, { { 1, 0 } }, { { -1, 0 } }, { { 0, -1 } } },
//			{ { { 0, 1 }, { 0, -1 } }, { { 1, 0 }, { -1, 0 } } },
//			{ { { -1, 0 }, { 0, 1 } }, { { 0, 1 }, { 1, 0 } }, { { -1, 0 }, { 1, 0 } }, { { -1, 0 }, { 0, -1 } } },
//			{ { { 0, 1 }, { 1, 0 }, { 0, -1 } }, { { -1, 0 }, { 1, 0 }, { 0, -1 } }, { { -1, 0 }, { 0, 1 }, { 0, -1 } },
//					{ { -1, 0 }, { 0, 1 }, { 1, 0 } } },
//			{ { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } } } };

	static int N, M, Map[][], Max;
	static boolean check[][];
	static ArrayList<int[]> li = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map = new int[N][M];
		Max = Integer.MAX_VALUE;
		check = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
				if (Map[i][j] != 0) {
					check[i][j] = true;
					if (Map[i][j] != 6) {
						li.add(new int[] { i, j, Map[i][j] });
					}
				}
			}
		}

		// df(check, 0);
		ct(check,0);
		System.out.println(Max);

	}

	static public void ct(boolean ch[][], int cnt) {
		if(cnt == li.size()) {
			int sum = 0;
			for (int i = 0; i < N; i++) {

				for (int j = 0; j < M; j++) {
					if(!ch[i][j]) sum++;
				}
			}
			
			Max = Math.min(Max, sum);
			
			return;
		}
		int[] a = li.get(cnt);
		int x = a[0];
		int y = a[1];
		int type = a[2];

		switch (type) {
		case 1:
			for (int i = 0; i < 4; i++) {
				int nextX = x;
				int nextY = y;
				boolean nextCh[][] = copy(ch);
				while (true) {
					nextX += cctv[i][0];
					nextY += cctv[i][1];

					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || Map[nextX][nextY] == 6) {
						break;
					}

					nextCh[nextX][nextY] = true;
				}
				ct(nextCh, cnt + 1);
			}
			break;

		case 2:
			for (int i = 0; i < 2; i++) {
				int nextX = x;
				int nextY = y;
				boolean nextCh[][] = copy(ch);
				while (true) {
					nextX += cctv[i][0];
					nextY += cctv[i][1];

					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || Map[nextX][nextY] == 6) {
						break;
					}

					nextCh[nextX][nextY] = true;
				}

				nextX = x;
				nextY = y;
				while (true) {
					nextX += cctv[i + 2][0];
					nextY += cctv[i + 2][1];

					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || Map[nextX][nextY] == 6) {
						break;
					}

					nextCh[nextX][nextY] = true;
				}
				ct(nextCh, cnt + 1);
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				int nextX = x;
				int nextY = y;
				boolean nextCh[][] = copy(ch);
				while (true) {
					nextX += cctv[i][0];
					nextY += cctv[i][1];

					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || Map[nextX][nextY] == 6) {
						break;
					}

					nextCh[nextX][nextY] = true;
				}

				nextX = x;
				nextY = y;
				while (true) {
					nextX += cctv[(i + 1) % 4][0];
					nextY += cctv[(i + 1) % 4][1];

					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || Map[nextX][nextY] == 6) {
						break;
					}

					nextCh[nextX][nextY] = true;
				}
				ct(nextCh, cnt + 1);
			}
			break;

		case 4:

			for (int i = 0; i < 4; i++) {
				int nextX = x;
				int nextY = y;
				boolean nextCh[][] = copy(ch);
				while (true) {
					nextX += cctv[i][0];
					nextY += cctv[i][1];

					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || Map[nextX][nextY] == 6) {
						break;
					}

					nextCh[nextX][nextY] = true;
				}

				nextX = x;
				nextY = y;
				while (true) {
					nextX += cctv[(i + 1) % 4][0];
					nextY += cctv[(i + 1) % 4][1];

					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || Map[nextX][nextY] == 6) {
						break;
					}

					nextCh[nextX][nextY] = true;
				}
				nextX = x;
				nextY = y;
				while (true) {
					nextX += cctv[(i + 2) % 4][0];
					nextY += cctv[(i + 2) % 4][1];

					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || Map[nextX][nextY] == 6) {
						break;
					}

					nextCh[nextX][nextY] = true;
				}
				ct(nextCh, cnt + 1);
			}
			break;
		case 5:
			boolean nextCh[][] = copy(ch);
			for (int i = 0; i < 4; i++) {
				int nextX = x;
				int nextY = y;
				while (true) {
					nextX += cctv[i][0];
					nextY += cctv[i][1];

					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || Map[nextX][nextY] == 6) {
						break;
					}

					nextCh[nextX][nextY] = true;
				}
			}
			ct(nextCh, cnt + 1);
			break;

		default:
			break;
		}

	}

//	static public void df(boolean[][] ch, int cnt) {
//		if (cnt == li.size()) {
//			int sum = 0;
//			for (int i = 0; i < N; i++) {
//
//				for (int j = 0; j < M; j++) {
//					if(!ch[i][j]) sum++;
//				}
//			}
//			
//			Max = Math.min(Max, sum);
//			
//			return;
//		}
//
//		int now[] = li.get(cnt);
//		int x = now[0];
//		int y = now[1];
//		int ct = now[2];
//		for (int j = 0; j < cctv[ct].length; j++) {
//
//			boolean nextCh[][] = copy(ch);
//
//			for (int k = 0; k < cctv[ct][j].length; k++) {
//				int nextX = x;
//				int nextY = y;
//
//				while (true) {
//					nextX += cctv[ct][j][k][0];
//					nextY += cctv[ct][j][k][1];
//
//					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || Map[nextX][nextY] == 6) {
//						break;
//					}
//
//					nextCh[nextX][nextY] = true;
//				}
//			}
//
//			df(nextCh, cnt + 1);
//
//		}
//
//	}

	static public boolean[][] copy(boolean ch[][]) {
		boolean copy[][] = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = ch[i][j];
			}
		}

		return copy;
	}
}