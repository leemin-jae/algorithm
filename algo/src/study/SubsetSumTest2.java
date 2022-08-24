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
		N = sc.nextInt(); // 집합?�� ?���?
		S = sc.nextInt(); // 목표?��
		ans = 0;

		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset(0 , 0);
		System.out.println(ans);
	}

	public static void generateSubset(int cnt, int sum) { // �?분집?��?�� 고려?��?��?��?�� ?��?��, 직전까�? 고려?�� ?��?�� ?��
															// sum : 직전까�? 구성?�� �?분집?��?�� ?��

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

		// ?��?�� ?��?���? ?��?��
		isSelected[cnt] = true;
		generateSubset(cnt + 1, sum + input[cnt]);
		// ?��?�� ?��?���? 비선?��
		isSelected[cnt] = false;
		generateSubset(cnt + 1, sum);

	}
}
