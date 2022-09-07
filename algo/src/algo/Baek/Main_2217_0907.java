package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_2217_0907 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		Integer Map[] = new Integer[N];
		for(int i = 0 ;  i < N; i++) {
			Map[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(Map,Comparator.reverseOrder());

		int cnt = 0;
		int max = -9;
		for(int  i = 0  ; i < N; i++) {
			cnt++;
			max = Math.max(max, Map[i]*cnt);
			
		}
		
		System.out.println(max);
		
	}

}
