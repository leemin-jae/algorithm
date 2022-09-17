package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10816_0917 {
	static int N, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Map[] = new int[20000002];
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ;i++) {
			Map[Integer.parseInt(st.nextToken())+10000000]++;
		}
		
		M  = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M ; i++) {
			sb.append(Map[Integer.parseInt(st.nextToken()) +10000000]).append(" ");
		}
		
		System.out.println(sb);
		
	}

}
