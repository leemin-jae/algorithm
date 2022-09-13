package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1063_0913 {
	static int Map[][] = new int[9][9];
	static int delta[][] = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };
	static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String first = st.nextToken();
		
		int fst[] = { first.charAt(0) - 'A', first.charAt(1)- '1' };

		String second = st.nextToken();
		int sec[] = { second.charAt(0) - 'A', second.charAt(1)-'1' };

		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			move(fst, sec, s);
		}
		
		System.out.println((char)(fst[0]+'A') + "" +(char)(fst[1]+'1'));
		System.out.println((char)(sec[0]+'A') + "" +(char)(sec[1]+'1'));
	}

	public static void move(int[] king, int[] stone, String m) {
		int t = -1;
		int nextX = king[0];
		int nextY = king[1];
		int stoneX = stone[0];
		int stoneY = stone[1];
		switch (m) {
		case "R":// : 한 칸 오른쪽으로
			t = 0;
			break;
		case "L":// : 한 칸 왼쪽으로
			t = 1;
			break;
		case "B": // : 한 칸 아래로
			t = 2;
			break;
		case "T": // : 한 칸 위로
			t = 3;
			break;
		case "RT":// : 오른쪽 위 대각선으로
			t = 4;
			break;
		case "LT":// : 왼쪽 위 대각선으로
			t = 5;
			break;
		case "RB":// : 오른쪽 아래 대각선으로
			t = 6;
			break;
		case "LB": // : 왼쪽 아래 대각선으로
			t = 7;
			break;
		}

		nextX += delta[t][0];
		nextY += delta[t][1];

		if (nextX < 0 || nextX >= 8 || nextY < 0 || nextY >= 8) {
			return;
		}
		if (nextX == stone[0] && nextY == stone[1]) {
			stoneX += delta[t][0];
			stoneY += delta[t][1];
		}
		if (stoneX < 0 || stoneX >= 8 || stoneY < 0 || stoneY >= 8) {
			return;
		}
		king[0] = nextX;
		king[1] = nextY;
		stone[0] = stoneX;
		stone[1] = stoneY;

	}

}
