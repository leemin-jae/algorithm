package algo.SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author THkim
 */
// BFS + ?λ£κ΅¬μ‘? ??©??¬ λΉκ³΅κ°? μ²λ¦¬?κΈ?
public class Solution_5656_test {

	static class Point{
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N,W,H,min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			go(0,map);
			System.out.println("#"+tc+" "+min);
		}
	}

	static boolean go(int count,int[][] map) {// μ€λ³΅??΄ ?΄?©??¬ κ΅¬μ¬? ?μ§?κΈ?, λ²½λ?΄ ?€ λΆ??μ‘λ€λ©? true, ??λ©? false λ¦¬ν΄
		
		int result = getRemain(map);
		
		if(result == 0) {// λͺ¨λ  λ²½λ?΄ ?€ λΆ??μ‘λ€λ©?
			min = 0;
			return true;
		}
		
		if(count == N) { // λͺ¨λ  κ΅¬μ¬? ?€ ?μ‘λ€λ©?
			min = Math.min(min, result);
			return false;
		}
		int[][] newMap = new int[H][W];
		// 0?΄λΆ??° W-1?΄κΉμ? κ΅¬μ¬ ?? Έλ³΄κΈ°
		for (int c = 0; c < W; c++) {
			
			// κ΅¬μ¬? λ§λ λ²½λ μ°ΎκΈ°
			int r = 0;
			while(r<H && map[r][c]==0) ++r; // λΉκ³΅κ°μ΄λ©? κ³μ?΄? ??λ‘?
			
			// ?΄?Ή ?΄?? λ²½λ?΄ ??
			if(r==H) continue;
			
			// λ°°μ΄? ??λ₯? λ°±μ
			copy(map,newMap);
			boom(newMap,r,c); // ??¬ λ²½λ κΈ°μ??Όλ‘? μ£Όλ?? κ°??₯? λͺ¨λ  λ²½λ ?¨κ»? ?°? μ²λ¦¬
			down(newMap); // λΆ??μ§? λ²½λ ? λ¦?
			
			if(go(count+1, newMap)) return true; // ?€? κ΅¬μ¬ ?μ§??¬ go
		}
		return false;
	}
	
	static void boom(int[][] map, int r, int c) { // r,c ?μΉμ? μ£Όλ?? κ°??₯? λͺ¨λ  λ²½λ? ?¨κ»? λΆ??? μ²λ¦¬ 
		Queue<Point> queue = new LinkedList<Point>();
		if(map[r][c]>1) { // λ²½λ?¬κΈ°κ? 2?΄??΄λ©?
			queue.offer(new Point(r,c,map[r][c]));
		}
		map[r][c] = 0; // ?? ?? ? κ±°μ²λ¦?(λΉ? κ³΅κ°?Όλ‘? ...) : visit μ²λ¦¬ ?­? 
		
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r, nc = p.c;
			
				for (int k = 1; k < p.cnt; k++) { // λ²½λ? ?¬κΈ?-1λ§νΌ λ°λ³΅
					nr += dr[d];
					nc += dc[d];
					if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]>0) {
						if(map[nr][nc]>1) { // μ£Όλ? λ²½λ? ??₯? μ£Όλ λ²½λ?΄λ©?
							queue.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0; //  ? κ±? μ²λ¦¬
					}
				}
			}
		}
	}
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static void down(int[][] map) {// λΆ??μ§? λ²½λ ? λ¦?,?¨?? λ²½λ ? λ¦?!!(κ³΅μ€? ? ?? λ²½λ? ??λ‘? ?΄λ¦¬κΈ°)
		for (int c = 0; c < W; c++) {
			int r = H-1;// ??? ??
			while(r>=0) {
				if(map[r][c]>0) { // λ²½λ μ°ΎκΈ°
					list.add(map[r][c]);
					map[r][c] = 0;
				}
				r--;
			} // λΆ??μ§?μ§? ?κ³? ?¨??? λ²½λ λ¦¬μ€?Έ? ?€ ?΄κΈ?, λ²½λ?΄ ?? ?λ¦¬λ λΉκ³΅κ°μΌλ‘? μ²λ¦¬κ°? ?¨.
			
			r = H-1;
			for (int a : list) { // λ²½λλ¦¬μ€?Έ
				map[r--][c] = a;
			}
			list.clear();
		}
	}
	static int getRemain(int[][] map) { // ?¨?? λ²½λ ? λ¦¬ν΄
		int count = 0;
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if(map[r][c]>0) ++count;
			}
		}
		return count;
	}
	static void copy(int[][] map, int[][] newMap) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];
			}
		}
	}
}
















