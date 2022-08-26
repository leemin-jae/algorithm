package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920_0826 {
	static int N, M;
	static int A[], B[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		A = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < M ; i++) {
			
			int std = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = A.length -1;
			while(true) {
				
				if(start > end) {
					System.out.println(0);
					break;
				}
				
				int mid = (start+end)/2;
				if(A[mid] == std) {
					System.out.println(1);
					break;
				}else if(A[mid] < std) {
					start = mid+1;
				}else {
					end = mid-1;
				}	
			}
			
		}
		
		
	}

}
