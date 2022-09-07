package algo.Baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1339_0906 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		N = Integer.parseInt(br.readLine());
		
		int ap[] = new int[26];
		
		for(int i = 0 ; i < N ; i++) {
			String now = br.readLine();
			
			for(int j = 0 ; j < now.length() ; j++) {
				ap[now.charAt(j) - 65] += Math.pow(10, now.length() - 1 - j);
				
				
			}
			
			
		}
		
		int sum = 0;
		for(int i = 9 ; i >=0 ; i--) {
			int max = -1;
			int std = -1;
			for(int j = 0 ; j < ap.length ; j++) {
				if(ap[j] > max) {
					max = ap[j];
					std = j;
				}
			}
			
			sum += max*i;
			ap[std] = 0;
		}
		
		System.out.println(sum);
		
	}

}
