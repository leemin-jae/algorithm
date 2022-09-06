package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main_12852_0906 {
	static int N;

	static class Node {
		int x;
		String s;

		Node(int x, String s) {
			this.x = x;
			this.s = s;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		Node[] node = new Node[N + 1];
		node[1] = new Node(0, "1 ");
		for (int i = 1; i <= N; i++) {

			int check[] = { i * 3, i * 2, i + 1 };

			for (int k = 0; k < check.length; k++) {
				if (check[k] <= N) {
					if (node[check[k]] == null || node[check[k]].x > node[i].x + 1) {
						node[check[k]] = new Node(node[i].x + 1, check[k] + " " + node[i].s);
					}
				}

			}
		}

		System.out.println(node[N].x);
		System.out.println(node[N].s);

	}

}
