package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2920_0912 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a[] = new int[8];
		for(int i = 0 ; i < 8 ; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean des = false;
		boolean asc = false;
		
		for(int i = 0; i<8; i++) {
			if(des && asc) {
				break;
			}
			if(a[i] != i+1) {
				asc = true;
			}
			if(a[i] != 8-i) {
				des = true;
			}
		}
		
		if(des && asc) {
			System.out.println("mixed");
		}else if(!des) {
			System.out.println("descending");
		}else {
			System.out.println("ascending");
		}
		
	
	}

}
