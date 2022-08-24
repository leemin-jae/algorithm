package study.pcs;

import java.util.Arrays;
import java.util.Scanner;

//nPr
//nê°œì˜ ?ˆ˜ ?…? ¥ë°›ì•„ ì²˜ë¦¬
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
	
	//?˜„?¬ ?ë¦¬ì— ?ˆ˜ ë½‘ê¸°
	public static void permutation(int cnt) { // cnt : ì§„ì „ê¹Œì? ë½‘ì? ?ˆ˜ ê°œìˆ˜
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// ?…? ¥ë°›ì? ëª¨ë“  ?ˆ˜ë¥? ?˜„?¬ ?ë¦¬ì— ?„£ê¸?
		for (int i = 0; i < N; i++) {
			//ê¸°ì¡´ ?ë¦¬ì˜ ?ˆ˜?“¤ê³? ì¤‘ë³µ?˜?Š”ì§? ì²´í¬
			if(isSelected[i]) continue;
			
			numbers[cnt] = input[i];
			isSelected[i] = true;
			//?‹¤?Œ?ˆ˜ ë½‘ìœ¼?Ÿ¬ ê°?ê¸?
			permutation(cnt+1);
			isSelected[i] = false;
			
		}
	}

}
