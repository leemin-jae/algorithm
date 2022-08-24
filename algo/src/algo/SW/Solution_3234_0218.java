package algo.SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234_0218 {
	static int N, total, count, result;
	static boolean isSelected[];
	static int hv[];

	public static void main(String[] args) throws Throwable, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			isSelected = new boolean[N];
			hv = new int[N];
			st = new StringTokenizer(br.readLine());

			total = 0;
			count = 0;
			result = 0;
			
			for (int i = 0; i < N; i++) {
				hv[i] = Integer.parseInt(st.nextToken());
				total += hv[i];
			}

			subset(0, 0, 0);
			System.out.println(result);
		}

	}
	
	public static void arrys(int cnt, int flag) {
		if(cnt == N) {
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			arrys(cnt + 1, flag | 1 << i);  
		}
		
	}
	public static void subset(int cnt, int left, int sum) {
		if (cnt == N) {
			if (total - sum < sum) {

				select(0, 0, N, left);
				int left_num = count;
				System.out.println(count);
				count = 0;
				select(0, 0, N - left, N - left);
				int right_num = count;
				System.out.println(count);
				count = 0;

				result += left_num * right_num;
				System.out.println(left + " " + result);
				return;

			} else { // ?˜¤ë¥¸ìª½?´ ?™¼ìª½ë³´?‹¤ ë¬´ê±°?š°ë©? return
				return;
			}
		}

		isSelected[cnt] = true;
		subset(cnt + 1, left + 1, sum + hv[cnt]); // trueë¡? ê³ ë¥¸ ì¶”ê? ?™¼ìª? , sum?? ?™¼ìª½ì— ?˜¬?¼?? ?žˆ?Š” ì¶”ì˜ ë¬´ê²Œ
		// ?˜„?ž¬ ?›?†Œë¥? ë¹„ì„ ?ƒ
		isSelected[cnt] = false;
		subset(cnt + 1, left, sum);

	}

	public static void select(int cnt, int flag, int space, int end) { // cnt : ëª‡ê°œ ë½‘ì•˜?Š”ì§? , flag : ?™•?¸?š© ë¹„íŠ¸
		if (cnt == end) {
			count++;
			return;
		}

		for (int i = 0; i < space; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			select(cnt + 1, flag | 1 << i, space, end);
		}
	}
}
