package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16953_0901 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		while(true) {
			if(B%2 == 0) {
				B = B/2;
				sum++;
			}else if(B%10 == 1){
				B = (B-1)/10;
				sum++;
			}else {
				sum = -2;
				break;
			}
//			System.out.println(B);
			if(B == A)  break;
			if(B < A) {
				sum = -2;
				break;
			}
		}
		
		System.out.println(sum+1);
	}
}
