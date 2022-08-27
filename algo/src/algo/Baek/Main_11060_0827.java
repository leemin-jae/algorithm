package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11060_0827 {
	static int N, Map[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		Map = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Map[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		int num = 0;

		while (true) {
			int max = -1;
			int next = -1;
			for (int i = 1; i <= Map[cnt]; i++) {
				// (cnt + i) 갈수 있는 자리
				// Map[cnt+i] 그 자리가 얼마나 더 가는지
				// (cnt+ i) + Map[cnt+i]
				if ((cnt + i) + Map[cnt + i] > max) {
					max = (cnt + i) + Map[cnt + i];
					next = cnt + i;
				}
			}

			cnt = next;
			num++;
			if (next == -1) {
				break;
			}
			if (max >= N - 1) {
				num++;
				break;
			}

		}
		if (N == 1) {
			System.out.println(0);
		} else {
			System.out.println(cnt == -1 ? cnt : num);
		}
	}

}
