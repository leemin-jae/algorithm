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
				if(i != j && adjMatrix[i][j]==0) {//?��기자?��?��로의 ?��?�� ?��보�? ?��?���? ?��?��?��?���? ?��?���? INF�? 채우�?
					adjMatrix[i][j]=INF;
				}
			}
		}
		System.out.println("===========?��?��==========");
		print();
        // 출발�?-->경유�?-->목적�?�? 3�? 루프 ?��리면 ?��?��
        // 경유�?-->출발�?-->목적�?�? 3�? 루프 ?��?��?�� ?��?��
		for(int k=0; k<N; ++k) {
			for(int i=0; i<N; ++i) {
				if(i==k) continue; // 출발�??? 경유�?�? 같다�? ?��?�� 출발�?
				for(int j=0; j<N; ++j) {
					if(i==j || k==j) continue; // 경유�??? 목적�?�? 같거?�� 출발�?�? �? 목적�??���? ?��?��
					// 간선?�� ?��?��?���?...
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