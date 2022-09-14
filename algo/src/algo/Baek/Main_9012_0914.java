package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_0914 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int T = 0 ; T < tc ; T++) {
			
			Stack<Character> s = new Stack<>();
			
			String now = br.readLine();
			for(int i = 0 ; i < now.length(); i++) {
				char n = now.charAt(i);
				if(s.isEmpty()) {
					s.add(n);
				}else {
					if(s.peek() == '(' && n == ')') {
						s.pop();
					}else {
						s.add(n);
					}
				}
			}
			
			if(s.size() == 0) {
				sb.append("YES").append("\n");
			
			}else {
				sb.append("NO").append("\n");
			
			}
			
		}
		
		System.out.println(sb);
	}

}
