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
	
	public static void setQueen(int rowNo) { // rowNo : ?�을 ?��?��?��?��?�� ?��?�� ?��
		
		if(!isAvailable(rowNo-1)) return; // 직전까�??�� ?��?��?�� ?��망하�? ?��?���? 리턴
		
		//기본?��?�� : ?�을 모두 ?��?��?���?
		if(rowNo > N) {
			ans++;
			return;
			
		}
		
		//1?���??�� - n?��까�? ?�을 ?��?�� ?��?��
		for (int i = 1; i < N; i++) {
			col[rowNo] = i;
			setQueen(rowNo+1);
		}
	}
	
	public static boolean isAvailable(int rowNo) { // ?��?���? 마�?�? ??
		
		for (int i = 1; i < rowNo; i++) {
			if(col[rowNo] == col[i] || rowNo-i == Math.abs(col[rowNo] - col[i])) return false;
			
		}
		return true;
	}

}
