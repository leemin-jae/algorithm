package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_5430_0916 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			String p = br.readLine();

			int N = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			StringTokenizer st = new StringTokenizer(arr,"[],");
			List<Integer> li = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				li.add(Integer.parseInt(st.nextToken()));
			}

			int reverse = 1;
			boolean error = false;
			int len = li.size(); 
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) == 'R') {
					reverse *= -1;
				} else {
					
					if (len != 0) {
						if (reverse == 1) {
							li.remove(0);
						} else {
							li.remove(len - 1);
						}
						len--;
					} else {
						error = true;
						sb.append("error").append("\n");
						break;
					}
				}
			}

			if (!error) {
				sb.append("[");
				if (reverse == 1) {
					for (int i = 0; i < li.size(); i++) {
						sb.append(li.get(i) + ",");
					}

				} else {
					for (int i = li.size() - 1; i >= 0; i--) {
						sb.append(li.get(i) + ",");
					}

				}
				if (sb.charAt(sb.length() - 1) == ',') {
					sb.delete(sb.length() - 1, sb.length());
				}
				sb.append("]").append("\n");

			}
			li.clear();

		}
		System.out.println(sb);

	}

}
