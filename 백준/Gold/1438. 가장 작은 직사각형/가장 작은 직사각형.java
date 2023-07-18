import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N , Min, Max, M;

    static int delta[][] = {{0,1},{0,-1},{1,0},{-1,0}};

    static int Map[][];
    static int visited[][][];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] P = new int[N][2]; // 모든 좌표
        for (int i = 0; i < N; i++) {
            P[i][0] = sc.nextInt();
            P[i][1] = sc.nextInt();
        }
        sc.close();

        int[] Y = new int[N];
        for (int i = 0; i < N; i++) {
            Y[i] = P[i][1];
        }
        Arrays.sort(Y); // 좌표중에 y좌표만 정렬

        int n = N / 2;
        int A = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int y1 = Y[i];
                int y2 = Y[j];
                int[] T = new int[N];
                int idx = 0;
                for (int k = 0; k < N; k++) {
                    if (y1 <= P[k][1] && P[k][1] <= y2) {
                        T[idx++] = P[k][0];
                    }
                }
                if (idx >= n) {
                    Arrays.sort(T, 0, idx); // 범위 안에 들어오는 x좌표들을 정렬해두기
                    for (int k = 0; k < idx - n + 1; k++) {
                        A = Math.min(A, (y2 - y1 + 2) * (T[k + n - 1] - T[k] + 2)); // 정답이 될 수 있다면 최솟값을 구함
                    }
                }
            }
        }

        System.out.println(A);

    }

}