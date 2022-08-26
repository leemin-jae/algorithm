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
// BFS + ?��료구�? ?��?��?��?�� 빈공�? 처리?���?
public class Solution_5656_test {

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            super();
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, W, H, min;

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
            go(0, map);
            System.out.println("#" + tc + " " + min);
        }
    }

    static boolean go(int count, int[][] map) {// 중복?��?�� ?��?��?��?�� 구슬?�� ?���?�?, 벽돌?�� ?�� �??��졌다�? true, ?��?���? false 리턴

        int result = getRemain(map);

        if (result == 0) {// 모든 벽돌?�� ?�� �??��졌다�?
            min = 0;
            return true;
        }

        if (count == N) { // 모든 구슬?�� ?�� ?��졌다�?
            min = Math.min(min, result);
            return false;
        }
        int[][] newMap = new int[H][W];
        // 0?���??�� W-1?��까�? 구슬 ?��?��보기
        for (int c = 0; c < W; c++) {

            // 구슬?�� 맞는 벽돌 찾기
            int r = 0;
            while (r < H && map[r][c] == 0) ++r; // 빈공간이�? 계속?��?�� ?��?���?

            // ?��?�� ?��?? 벽돌?�� ?��?��
            if (r == H) continue;

            // 배열?�� ?��?���? 백업
            copy(map, newMap);
            boom(newMap, r, c); // ?��?�� 벽돌 기�??���? 주�??�� �??��?�� 모든 벽돌 ?���? ?��?�� 처리
            down(newMap); // �??���? 벽돌 ?���?

            if (go(count + 1, newMap)) return true; // ?��?�� 구슬 ?���??�� go
        }
        return false;
    }

    static void boom(int[][] map, int r, int c) { // r,c ?��치에?�� 주�??�� �??��?�� 모든 벽돌?�� ?���? �??��?�� 처리
        Queue<Point> queue = new LinkedList<Point>();
        if (map[r][c] > 1) { // 벽돌?��기�? 2?��?��?���?
            queue.offer(new Point(r, c, map[r][c]));
        }
        map[r][c] = 0; // ?��?��?? ?��거처�?(�? 공간?���? ...) : visit 처리 ?��?��

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r, nc = p.c;

                for (int k = 1; k < p.cnt; k++) { // 벽돌?�� ?���?-1만큼 반복
                    nr += dr[d];
                    nc += dc[d];
                    if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] > 0) {
                        if (map[nr][nc] > 1) { // 주�? 벽돌?�� ?��?��?�� 주는 벽돌?���?
                            queue.offer(new Point(nr, nc, map[nr][nc]));
                        }
                        map[nr][nc] = 0; //  ?���? 처리
                    }
                }
            }
        }
    }

    static ArrayList<Integer> list = new ArrayList<Integer>();

    static void down(int[][] map) {// �??���? 벽돌 ?���?,?��?? 벽돌 ?���?!!(공중?�� ?��?��?�� 벽돌?�� ?��?���? ?��리기)
        for (int c = 0; c < W; c++) {
            int r = H - 1;// ?��?��?�� ?��?��
            while (r >= 0) {
                if (map[r][c] > 0) { // 벽돌 찾기
                    list.add(map[r][c]);
                    map[r][c] = 0;
                }
                r--;
            } // �??���?�? ?���? ?��?��?��?�� 벽돌 리스?��?�� ?�� ?���?, 벽돌?�� ?��?�� ?��리는 빈공간으�? 처리�? ?��.

            r = H - 1;
            for (int a : list) { // 벽돌리스?��
                map[r--][c] = a;
            }
            list.clear();
        }
    }

    static int getRemain(int[][] map) { // ?��?? 벽돌 ?�� 리턴
        int count = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (map[r][c] > 0) ++count;
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
















