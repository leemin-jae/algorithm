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
// BFS + ?ë£Œêµ¬ì¡? ?™œ?š©?•˜?—¬ ë¹ˆê³µê°? ì²˜ë¦¬?•˜ê¸?
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

	static boolean go(int count,int[][] map) {// ì¤‘ë³µ?ˆœ?—´ ?´?š©?•˜?—¬ êµ¬ìŠ¬?„ ?˜ì§?ê¸?, ë²½ëŒ?´ ?‹¤ ë¶??„œì¡Œë‹¤ë©? true, ?•„?‹ˆë©? false ë¦¬í„´
		
		int result = getRemain(map);
		
		if(result == 0) {// ëª¨ë“  ë²½ëŒ?´ ?‹¤ ë¶??„œì¡Œë‹¤ë©?
			min = 0;
			return true;
		}
		
		if(count == N) { // ëª¨ë“  êµ¬ìŠ¬?„ ?‹¤ ?˜ì¡Œë‹¤ë©?
			min = Math.min(min, result);
			return false;
		}
		int[][] newMap = new int[H][W];
		// 0?—´ë¶??„° W-1?—´ê¹Œì? êµ¬ìŠ¬ ?˜? ¸ë³´ê¸°
		for (int c = 0; c < W; c++) {
			
			// êµ¬ìŠ¬?— ë§ëŠ” ë²½ëŒ ì°¾ê¸°
			int r = 0;
			while(r<H && map[r][c]==0) ++r; // ë¹ˆê³µê°„ì´ë©? ê³„ì†?•´?„œ ?•„?˜ë¡?
			
			// ?•´?‹¹ ?—´?? ë²½ëŒ?´ ?—†?Œ
			if(r==H) continue;
			
			// ë°°ì—´?˜ ?ƒ?ƒœë¥? ë°±ì—…
			copy(map,newMap);
			boom(newMap,r,c); // ?˜„?¬ ë²½ëŒ ê¸°ì??œ¼ë¡? ì£¼ë??˜ ê°??Š¥?•œ ëª¨ë“  ë²½ëŒ ?•¨ê»? ?—°?‡„ ì²˜ë¦¬
			down(newMap); // ë¶??„œì§? ë²½ëŒ ? •ë¦?
			
			if(go(count+1, newMap)) return true; // ?‹¤?Œ êµ¬ìŠ¬ ?˜ì§??Ÿ¬ go
		}
		return false;
	}
	
	static void boom(int[][] map, int r, int c) { // r,c ?œ„ì¹˜ì—?„œ ì£¼ë??˜ ê°??Š¥?•œ ëª¨ë“  ë²½ëŒ?„ ?•¨ê»? ë¶??ˆ˜?Š” ì²˜ë¦¬ 
		Queue<Point> queue = new LinkedList<Point>();
		if(map[r][c]>1) { // ë²½ëŒ?¬ê¸°ê? 2?´?ƒ?´ë©?
			queue.offer(new Point(r,c,map[r][c]));
		}
		map[r][c] = 0; // ??‹ ?? ? œê±°ì²˜ë¦?(ë¹? ê³µê°„?œ¼ë¡? ...) : visit ì²˜ë¦¬ ?—­?• 
		
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r, nc = p.c;
			
				for (int k = 1; k < p.cnt; k++) { // ë²½ëŒ?˜ ?¬ê¸?-1ë§Œí¼ ë°˜ë³µ
					nr += dr[d];
					nc += dc[d];
					if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]>0) {
						if(map[nr][nc]>1) { // ì£¼ë? ë²½ëŒ?— ?˜?–¥?„ ì£¼ëŠ” ë²½ëŒ?´ë©?
							queue.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0; //  ? œê±? ì²˜ë¦¬
					}
				}
			}
		}
	}
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static void down(int[][] map) {// ë¶??„œì§? ë²½ëŒ ? •ë¦?,?‚¨?? ë²½ëŒ ? •ë¦?!!(ê³µì¤‘?— ?– ?ˆ?Š” ë²½ëŒ?„ ?•„?˜ë¡? ?‚´ë¦¬ê¸°)
		for (int c = 0; c < W; c++) {
			int r = H-1;// ?•„?˜?–‰ ?‹œ?‘
			while(r>=0) {
				if(map[r][c]>0) { // ë²½ëŒ ì°¾ê¸°
					list.add(map[r][c]);
					map[r][c] = 0;
				}
				r--;
			} // ë¶??„œì§?ì§? ?•Šê³? ?‚¨?•„?ˆ?Š” ë²½ëŒ ë¦¬ìŠ¤?Š¸?— ?‹¤ ?‹´ê¸?, ë²½ëŒ?´ ?ˆ?˜ ?ë¦¬ëŠ” ë¹ˆê³µê°„ìœ¼ë¡? ì²˜ë¦¬ê°? ?¨.
			
			r = H-1;
			for (int a : list) { // ë²½ëŒë¦¬ìŠ¤?Š¸
				map[r--][c] = a;
			}
			list.clear();
		}
	}
	static int getRemain(int[][] map) { // ?‚¨?? ë²½ëŒ ?ˆ˜ ë¦¬í„´
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
















