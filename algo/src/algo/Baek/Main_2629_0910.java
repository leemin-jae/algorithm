package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2629_0910 {
	static int N, M;
	static int w[], b[];
	static boolean check[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		w = new int[N+1];

		check = new boolean[31][40001]; // 추로 잴수 있는 무게를 확인하기 위한 배열, 추가 최대 30개 추의 무게가 500이하이므로 최대 무게는 15000으로 할당

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}

		find(0, 0);

		M = Integer.parseInt(br.readLine());
		b = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			System.out.print(check[N][b[i]]?"Y ": "N ");
		}

	}

	static public void find(int idx, int weight) { // 조합을 통해서 계산
		
		if(check[idx][weight]) return;
		
		check[idx][weight] = true;

		if (idx == N)
			return;

		find(idx + 1,weight + w[idx+1] );
		find(idx + 1,Math.abs(weight - w[idx+1]));
		find(idx + 1,weight);

	}

}