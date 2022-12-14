package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1931_0829 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int timeTable[][] = new int[N][2];

		for (int i = 0; i < N; i++) {
			timeTable[i][0] = sc.nextInt();
			timeTable[i][1] = sc.nextInt();
		}
		Arrays.sort(timeTable, (a, b) -> {
			if(a[1] == b[1]) return a[0] - b[0];
			return a[1] - b[1];
		});

		int ans = 0;
		int time = 0;

		for (int i = 0; i < N; i++) {
			if (timeTable[i][0] >= time) { 
				time = timeTable[i][1];
				ans++;
			}
		}
		System.out.println(ans);
	}
}
