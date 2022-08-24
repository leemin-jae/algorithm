package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17143_0413 {
	static int R, C, M;

	static class Node {
		int speed;
		int size;
		int d;

		Node(int speed, int d, int size) {
			this.speed = speed;
			this.size = size;
			this.d = d;
		}
	}

	static Node a[][], b[][];
	static int delta[][] = { {}, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		a = new Node[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			a[r][c] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		int sum = 0;
		for (int man = 1; man <= C; man++) {
			for (int fish = 1; fish <= R; fish++) { // ?˜„?¬ ?œ„ì¹˜ì—´?—?„œ ë¬¼ê³ ê¸? ?¡ê¸?
				if (a[fish][man] != null) {
					sum += a[fish][man].size;
					a[fish][man] = null;
					break;
				}
			}

			////////////////////////////////////////////
			b = new Node[R + 1][C + 1];

			for (int i = 1; i <= R; i++) { // ?ƒ?–´ ?´?™
				for (int j = 1; j <= C; j++) {
					if (a[i][j] != null) {
						move(i, j);
					}

				}
			}
			
			copy();

		}
		System.out.println(sum);
	}

	static public void copy() {
		for (int i = 1; i <= R; i++) { 
			for (int j = 1; j <= C; j++) {
				if (b[i][j] != null) {
					a[i][j] = new Node(b[i][j].speed , b[i][j].d , b[i][j].size);
				}
			}
		}

	}

	static public void move(int r, int c) {
		int d = a[r][c].d;
		int speed = a[r][c].speed;
		int size = a[r][c].size;

		int nextX = r;
		int nextY = c;

		for (int i = 0; i < speed; i++) {
			nextX += delta[d][0] ; // ?‹¤?Œ ì¢Œí‘œ
			nextY += delta[d][1] ;

			if (nextX < 1 || nextX > R || nextY < 1 || nextY > C) {
				nextX -= delta[d][0] ; // ë²”ìœ„ ë°–ì„ ?‚˜ê°?ë©? ?›?˜ ì¢Œí‘œë¡? ë³?ê²?
				nextY -= delta[d][1] ;

				 // ë°©í–¥?„ ë°˜ë?ë¡? ë°”ê¿”ì¤?
				if(d == 1) d = 2;
				else if(d == 2) d= 1;
				else if(d == 3) d= 4;
				else if(d == 4) d= 3;
				
				nextX += delta[d][0] ; // ë°©í–¥?´ ë°”ë?Œê³  ?‹¤?Œ ì¢Œí‘œ
				nextY += delta[d][1] ;

			}

		}

		if (b[nextX][nextY] == null) { // ?´?™?•œ ?œ„ì¹˜ì— ?•„ë¬´ê²ƒ?„ ?—†?„ ?•Œ
			b[nextX][nextY] = new Node(speed, d, size);

		} else { // ?´?™?•œ ?œ„ì¹˜ì— ?´ë¯? ?ƒ?–´ê°? ?ˆ?„?•Œ
			if (b[nextX][nextY].size < size) { // ì§?ê¸? ?ƒ?–´ê°? ?¬ê¸? ê°? ?” ?°ê²½ìš° ë³?ê²½í•´ì¤??‹¤
				b[nextX][nextY] = new Node(speed, d, size);
			}
		}

		a[r][c] = null;

	}

}
