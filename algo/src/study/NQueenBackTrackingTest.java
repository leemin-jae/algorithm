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
	
	public static void setQueen(int rowNo) { // rowNo : ?¸ì„ ?‘?–´?•¼?•˜?Š” ?˜„?¬ ?–‰
		
		if(!isAvailable(rowNo-1)) return; // ì§ì „ê¹Œì??˜ ?ƒ?™©?´ ?œ ë§í•˜ì§? ?•Š?‹¤ë©? ë¦¬í„´
		
		//ê¸°ë³¸?ŒŒ?Š¸ : ?¸ì„ ëª¨ë‘ ?†“?•˜?‹¤ë©?
		if(rowNo > N) {
			ans++;
			return;
			
		}
		
		//1?—´ë¶??„° - n?—´ê¹Œì? ?¸ì„ ?†“?Š” ?‹œ?„
		for (int i = 1; i < N; i++) {
			col[rowNo] = i;
			setQueen(rowNo+1);
		}
	}
	
	public static boolean isAvailable(int rowNo) { // ?†“?•„ì§? ë§ˆì?ë§? ??
		
		for (int i = 1; i < rowNo; i++) {
			if(col[rowNo] == col[i] || rowNo-i == Math.abs(col[rowNo] - col[i])) return false;
			
		}
		return true;
	}

}
