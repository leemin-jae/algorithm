package study.pcs;

import java.util.Arrays;
import java.util.Scanner;

//nPr
//n개의 ?�� ?��?��받아 처리
public class PermutationTest {
	static int N, R;
	static int[] input, numbers;
	static boolean[] isSelected;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers= new int[R];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		
		permutation(0);
	}
	
	//?��?�� ?��리에 ?�� 뽑기
	public static void permutation(int cnt) { // cnt : 진전까�? 뽑�? ?�� 개수
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// ?��?��받�? 모든 ?���? ?��?�� ?��리에 ?���?
		for (int i = 0; i < N; i++) {
			//기존 ?��리의 ?��?���? 중복?��?���? 체크
			if(isSelected[i]) continue;
			
			numbers[cnt] = input[i];
			isSelected[i] = true;
			//?��?��?�� 뽑으?�� �?�?
			permutation(cnt+1);
			isSelected[i] = false;
			
		}
	}

}
