package study.pcs;

import java.util.Scanner;

public class SubsetTest {
	static int N, input[];
	static boolean[] isSelected;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset(0);
	}

	public static void generateSubset(int cnt) { // λΆ?λΆμ§?©? κ³ λ €?΄?Ό?? ??, μ§μ κΉμ? κ³ λ €? ?? ?
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print((isSelected[i] ? input[i] : "X") + " ");
			}
			System.out.println();
			return;
		}

		// ??¬ ??λ₯? ? ?
		isSelected[cnt] = true;
		generateSubset(cnt + 1);
		// ??¬ ??λ₯? λΉμ ?
		isSelected[cnt] = false;
		generateSubset(cnt + 1);

	}
}
