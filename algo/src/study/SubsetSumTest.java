package study;

import java.util.Scanner;
/*
 * 
5 0
-7 -3 -2 5 8

 * 
 * 
 */
public class SubsetSumTest {
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
		generateSubset(0);
		System.out.println(ans);
	}

	public static void generateSubset(int cnt) { // λΆ?λΆμ§?©? κ³ λ €?΄?Ό?? ??, μ§μ κΉμ? κ³ λ €? ?? ?
		if (cnt == N) {

			int sum = 0;
			int elementCnt = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sum += input[i];
					elementCnt ++;
				}
				
			}

			if (sum == S && elementCnt > 0) {
				++ans;
				for (int i = 0; i < N; i++) {
					System.out.print(isSelected[i] ? input[i]  + " ": "");
				}
				System.out.println();
			}
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
