package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_10867_0911 {
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		Set<Integer> s = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i  = 0 ; i < n ; i++) {
			s.add(Integer.parseInt(st.nextToken()));
		}
		List<Integer> l = new ArrayList<Integer>(s);
		Collections.sort(l);
//		Iterator<Integer> i = s.iterator();
//		while(i.hasNext()) {
//			System.out.print(i.next() + " ");
//		}
//		
		for(int it  = 0 ; it <  l.size() ; it++) {
			System.out.print(l.get(it) +  " ");
		}
	}

}
