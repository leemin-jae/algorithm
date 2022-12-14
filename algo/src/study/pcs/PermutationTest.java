package study.pcs;

import java.util.Arrays;
import java.util.Scanner;

//nPr
//nκ°μ ? ?? ₯λ°μ μ²λ¦¬
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
	
	//??¬ ?λ¦¬μ ? λ½κΈ°
	public static void permutation(int cnt) { // cnt : μ§μ κΉμ? λ½μ? ? κ°μ
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// ?? ₯λ°μ? λͺ¨λ  ?λ₯? ??¬ ?λ¦¬μ ?£κΈ?
		for (int i = 0; i < N; i++) {
			//κΈ°μ‘΄ ?λ¦¬μ ??€κ³? μ€λ³΅??μ§? μ²΄ν¬
			if(isSelected[i]) continue;
			
			numbers[cnt] = input[i];
			isSelected[i] = true;
			//?€?? λ½μΌ?¬ κ°?κΈ?
			permutation(cnt+1);
			isSelected[i] = false;
			
		}
	}

}
