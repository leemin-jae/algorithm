package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17136_0906 {
	static int Min;
	static List<Node> list;

	static class Node implements Comparable<Node> {
		int x;
		int y;
		boolean check;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
			this.check = false;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.x != o.x ? this.x - o.x : this.y - o.y;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Min = Integer.MAX_VALUE;
		boolean Map[][] = new boolean[11][11];
		int num[] = new int[6];
		Arrays.fill(num, 5);
		list = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 10; j++) {
				if (st.nextToken().equals("1")) {
					list.add(new Node(i, j));
					Map[i][j] = true;
				}
			}
		}

		start(0, Map, num, 0);

		System.out.println(Min == Integer.MAX_VALUE ? -1 : Min);

	}

	static public void start(int start, boolean check[][], int num[], int min) {
		if (min > Min) {
			return;
		}
		if (list.size() == 0) {
			Min = 0;
			return;
		}
		for (int q = start; q < list.size(); q++) {
			Node now = list.get(q);
			int i = now.x;
			int j = now.y;
			if (check[i][j]) {
				for (int k = 5; k > 0; k--) {
					boolean Map[][] = copy(check);
					if (check(k, i, j, Map) && num[k] != 0) {
						num[k]--;
						run(k, i, j, Map);
						start(q, Map, num, min + 1);
						num[k]++;
					}
				}
			}

			if (q == list.size() - 1 && !iscount(check)) {
				Min = Min > min ? min : Min;
			}

		}

	}

	static public boolean iscount(boolean Map[][]) {
		boolean flag = false;
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				if (Map[i][j]) {
					flag = true;
				}
			}
		}
		return flag;
	}

	static public boolean check(int n, int x, int y, boolean Map[][]) {
		boolean flag = true;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (x + i < 1 || x + i > 10 || y + j < 1 || y + j > 10 || !Map[x + i][y + j]) {
					flag = false;
				}
			}
		}

		return flag;

	}

	static public void run(int n, int x, int y, boolean Map[][]) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Map[x + i][y + j] = false;

			}
		}
	}

	static public boolean[][] copy(boolean[][] check) {
		boolean Map[][] = new boolean[11][11];

		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				if (check[i][j]) {
					Map[i][j] = true;
				}
			}
		}

		return Map;
	}
}
