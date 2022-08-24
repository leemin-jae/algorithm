package study;

import java.util.Scanner;

/**
 * @author taeheekim
 */
public class Floyd {

	static final int INF = 9999999;
	static int N,adjMatrix[][];
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adjMatrix = new int[N][N];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				adjMatrix[i][j] = sc.nextInt();
				if(i != j && adjMatrix[i][j]==0) {//?ê¸°ì?‹ ?œ¼ë¡œì˜ ?¸? ‘ ? •ë³´ê? ?•„?‹ˆê³? ?¸? ‘?•´?ˆì§? ?•Š?‹¤ë©? INFë¡? ì±„ìš°ê¸?
					adjMatrix[i][j]=INF;
				}
			}
		}
		System.out.println("===========?…? ¥==========");
		print();
        // ì¶œë°œì§?-->ê²½ìœ ì§?-->ëª©ì ì§?ë¡? 3ì¤? ë£¨í”„ ?Œë¦¬ë©´ ?˜¤?‹µ
        // ê²½ìœ ì§?-->ì¶œë°œì§?-->ëª©ì ì§?ë¡? 3ì¤? ë£¨í”„ ?Œ? ¤?•¼ ? •?‹µ
		for(int k=0; k<N; ++k) {
			for(int i=0; i<N; ++i) {
				if(i==k) continue; // ì¶œë°œì§??? ê²½ìœ ì§?ê°? ê°™ë‹¤ë©? ?‹¤?Œ ì¶œë°œì§?
				for(int j=0; j<N; ++j) {
					if(i==j || k==j) continue; // ê²½ìœ ì§??? ëª©ì ì§?ê°? ê°™ê±°?‚˜ ì¶œë°œì§?ê°? ê³? ëª©ì ì§??¼ë©? ?Œ¨?Š¤
					// ê°„ì„ ?´ ?–‘?ˆ˜?´ë©?...
					if(adjMatrix[i][j] > adjMatrix[i][k]+adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k]+adjMatrix[k][j];
					}
				}
			}
			print();
		}
	
	}
	private static void print() {
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				System.out.print(adjMatrix[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("=====================================");
		
	}

}