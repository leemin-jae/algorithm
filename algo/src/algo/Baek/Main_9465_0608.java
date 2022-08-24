package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465_0608 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sb = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());

			int arr[][] = new int[2][n];
			int dp[][] = new int[2][n];
			for (int i = 0; i < 2; i++) {
				sb = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(sb.nextToken());
				}
			}
			if (n != 1) {
				dp[0][0] = arr[0][0];
				dp[1][0] = arr[1][0];

				dp[0][1] = dp[1][0] + arr[0][1];
				dp[1][1] = dp[0][0] + arr[1][1];
			} else {
				dp[0][0] = arr[0][0];
				dp[1][0] = arr[1][0];

			}

			for (int i = 2; i < n; i++) {
				dp[0][i] = Math.max(dp[1][i - 1] + arr[0][i], dp[1][i - 2] + arr[0][i]);
				dp[1][i] = Math.max(dp[0][i - 1] + arr[1][i], dp[0][i - 2] + arr[1][i]);
			}

			System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));

		}
	}

}
