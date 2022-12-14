package study;

import java.util.Scanner;

public class NQueenBackTrackingTest {
	static int N,ans;
	static int col[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = 0;
		col = new int[N+1];
		
		setQueen(1);
		System.out.println(ans);
	}
	
	public static void setQueen(int rowNo) { // rowNo : ?Έμ ??΄?Ό?? ??¬ ?
		
		if(!isAvailable(rowNo-1)) return; // μ§μ κΉμ?? ??©?΄ ? λ§νμ§? ??€λ©? λ¦¬ν΄
		
		//κΈ°λ³Έ??Έ : ?Έμ λͺ¨λ ???€λ©?
		if(rowNo > N) {
			ans++;
			return;
			
		}
		
		//1?΄λΆ??° - n?΄κΉμ? ?Έμ ?? ??
		for (int i = 1; i < N; i++) {
			col[rowNo] = i;
			setQueen(rowNo+1);
		}
	}
	
	public static boolean isAvailable(int rowNo) { // ??μ§? λ§μ?λ§? ??
		
		for (int i = 1; i < rowNo; i++) {
			if(col[rowNo] == col[i] || rowNo-i == Math.abs(col[rowNo] - col[i])) return false;
			
		}
		return true;
	}

}
