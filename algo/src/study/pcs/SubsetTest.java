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

	public static void generateSubset(int cnt) { // �?분집?��?�� 고려?��?��?��?�� ?��?��, 직전까�? 고려?�� ?��?�� ?��
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print((isSelected[i] ? input[i] : "X") + " ");
			}
			System.out.println();
			return;
		}

		// ?��?�� ?��?���? ?��?��
		isSelected[cnt] = true;
		generateSubset(cnt + 1);
		// ?��?�� ?��?���? 비선?��
		isSelected[cnt] = false;
		generateSubset(cnt + 1);

	}
}
