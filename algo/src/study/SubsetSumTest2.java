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
		N = sc.nextInt(); // ì§‘í•©?˜ ?¬ê¸?
		S = sc.nextInt(); // ëª©í‘œ?•©
		ans = 0;

		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset(0 , 0);
		System.out.println(ans);
	}

	public static void generateSubset(int cnt, int sum) { // ë¶?ë¶„ì§‘?•©?— ê³ ë ¤?•´?•¼?•˜?Š” ?›?†Œ, ì§ì „ê¹Œì? ê³ ë ¤?•œ ?›?†Œ ?ˆ˜
															// sum : ì§ì „ê¹Œì? êµ¬ì„±?œ ë¶?ë¶„ì§‘?•©?˜ ?•©

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

		// ?˜„?¬ ?›?†Œë¥? ?„ ?ƒ
		isSelected[cnt] = true;
		generateSubset(cnt + 1, sum + input[cnt]);
		// ?˜„?¬ ?›?†Œë¥? ë¹„ì„ ?ƒ
		isSelected[cnt] = false;
		generateSubset(cnt + 1, sum);

	}
}
