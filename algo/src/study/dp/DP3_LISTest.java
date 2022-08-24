package study.dp;

import java.util.Arrays;
import java.util.Scanner;

public class DP3_LISTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] LIS = new int[N];

		for (int i = 0; i < LIS.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		for (int i = 0; i < LIS.length; i++) {
			LIS[i] = 1;  // ?���? ?��?�� LIS 구성?��?�� 길이 1 초기?��
			
			for (int j = 0; j < i; j++) { // �? ?��?���??�� i?��?�� 직전까�? 비교
				if(arr[j] < arr[i] && LIS[i] < LIS[j] +1) {
					LIS[i] = LIS[j] +1;
				}
				
			}
			if(max < LIS[i]) max = LIS[i];
			
		}
		
		System.out.println(max);

	}

}
