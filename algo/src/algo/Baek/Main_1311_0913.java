package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1311_0913 {
	static int delta[][] = { { 2, -1 }, { 2, 1 }, { -2, -1 }, { -2, 1 }, { 1, 2 }, { -1, 2 }, { 1, -2 }, { -1, -2 } };
	static boolean checkMap[][] = new boolean[6][6];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int now[] = { s.charAt(0) - 'A', s.charAt(1) - '1' };
		int first[] = new int[2];
		
		first[0] = now[0];
		first[1] = now[1];

		boolean check = false;
		for (int i = 1; i < 36; i++) {
			s = br.readLine();
			int next[] = { s.charAt(0) - 'A', s.charAt(1) - '1' };
			if (checkNext(now, next)) {
				now[0] = next[0];
				now[1] = next[1];
			} else {
				check = true;
				break;
			}
		}

		if (!check && checkNext(now, first)) {
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}
	}

	static public boolean checkNext(int now[], int next[]) {
		for (int i = 0; i < delta.length; i++) {
			int nextX = now[0] + delta[i][0];
			int nextY = now[1] + delta[i][1];

			if (nextX < 0 || nextX >= 6 || nextY < 0 || nextY >= 6 || checkMap[nextX][nextY])
				continue;

			if (nextX == next[0] && nextY == next[1]) {
				checkMap[nextX][nextY] = true;
				return true;
			}

		}

		return false;
	}
}
