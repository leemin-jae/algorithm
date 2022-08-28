package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11727_0828 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		long DP[] = new long[1001];
		
		DP[1] = 1;
		DP[2] = 3;
		
		for(int i = 3; i <=  N ;  i++) {
			DP[i] = (DP[i-1] + DP[i-2]*2)%10007;
		}
		
		System.out.println(DP[N]);
		
		
	}

}
