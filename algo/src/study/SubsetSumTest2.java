package study;

import java.util.Scanner;

/*
 * 


6 21
5 21 11 16 6 10
 * 
 * 
 */
public class SubsetSumTest2 {
	static int N, input[], S, ans;
	static boolean[] isSelected;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // μ§ν©? ?¬κΈ?
		S = sc.nextInt(); // λͺ©ν?©
		ans = 0;

		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset(0 , 0);
		System.out.println(ans);
	}

	public static void generateSubset(int cnt, int sum) { // λΆ?λΆμ§?©? κ³ λ €?΄?Ό?? ??, μ§μ κΉμ? κ³ λ €? ?? ?
															// sum : μ§μ κΉμ? κ΅¬μ±? λΆ?λΆμ§?©? ?©

		if (sum == S) {
			++ans;
			for (int i = 0; i < cnt; i++) {
				System.out.print(isSelected[i] ? input[i] + " " : "");
			}
			System.out.println();
			return;
		}
		if (sum > S) {
			return;
		}
		if (cnt == N) {
			return;
		}

		// ??¬ ??λ₯? ? ?
		isSelected[cnt] = true;
		generateSubset(cnt + 1, sum + input[cnt]);
		// ??¬ ??λ₯? λΉμ ?
		isSelected[cnt] = false;
		generateSubset(cnt + 1, sum);

	}
}
