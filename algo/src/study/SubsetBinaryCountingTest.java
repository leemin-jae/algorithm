package study;

import java.util.Scanner;

public class SubsetBinaryCountingTest {
	// static int N, input[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		generateSubset(input);
	}

	private static void generateSubset(int[] input) {
		int N = input.length;
		for (int flag = 0, caseCount = 1 << N; flag < caseCount; flag++) {
			// flag : ?›?†Œ?“¤?˜ ?„ ?ƒ ?ƒ?ƒœ?˜ ë¹„íŠ¸?—´
			for (int i = 0; i < N; i++) { // ê°? ë¹„íŠ¸?—´?˜ ?ƒ?ƒœë¥? ?™•?¸
				if ((flag & 1 << i) != 0) {
					System.out.print(input[i] + " " );
				}
			}
			System.out.println();
		}

	}
}
