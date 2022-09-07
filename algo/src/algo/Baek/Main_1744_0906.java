package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main_1744_0906 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		List<Integer> plus = new ArrayList<>();
		List<Integer> zero = new ArrayList<>();
		List<Integer> minus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a > 0) {
				plus.add(a);

			} else if (a < 0) {
				minus.add(a);
			} else {
				zero.add(a);
			}
		}

		plus.sort(Comparator.reverseOrder());
		minus.sort(Comparator.reverseOrder());

		int sum = 0;

		if (plus.size() % 2 != 0) {
			int a = plus.get(plus.size() - 1);
			plus.remove(plus.size() - 1);
			sum += a;
		}
		while (!plus.isEmpty()) {
			int first = plus.get(0);
			int second = plus.get(1);
			int now = first * second;
			if (first + second > first * second) {
				sum += first + second;

			} else {
				sum += first * second;
			}
			plus.remove(0);
			plus.remove(0);
		}

		if (minus.size() % 2 == 1) {
			if (!zero.isEmpty()) {
				minus.remove(0);
			} else {
				sum += minus.get(0);
				minus.remove(0);
			}
		}

		while (!minus.isEmpty()) {
			int first = minus.get(0);
			int second = minus.get(1);
			sum += first * second;
			minus.remove(0);
			minus.remove(0);
		}

		System.out.println(sum);

	}

}
