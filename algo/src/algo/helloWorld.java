package algo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class helloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<int []> list = new ArrayList<>();
		list.add(new int[] {4,1});
		list.add(new int[] {3,2});
		list.add(new int[] {2,3});
		list.add(new int[] {3,6});
		list.add(new int[] {2,7});
		list.add(new int[] {1,8});
		
		for(int[] l : list) {
			System.out.println(l[0] + " " + l[1]);
		}
		
		list.sort(new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}else {
					return o1[0] - o2[0];
				}
			}
		});
		
		System.out.println("==================");
		for(int[] l : list) {
			System.out.println(l[0] + " " + l[1]);
		}

	}

}
