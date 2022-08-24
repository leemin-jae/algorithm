package study.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {

	private static class MyComparator implements Comparator<int[]>{

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			int diff = o1[1] - o2[1];
			return diff != 0? diff : o1[0] - o2[0];
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int [][]arr = new int[][] {{1,10},{3,50},{4,52},{2,80},{5,52}};
		print(arr);
		System.out.println("==========? •? ¬ ?›„==========");
		//?—¬ê¸°ì„œ ?›?†Œ?Š” 1ì°¨ì› ë°°ì—´ int[] <-- ?–˜ê°? ?›?†Œ, ?¬ê¸? ?Œ?‹¨?˜ ê¸°ë¶„ ?•„ë¬´ê²ƒ?„ ?—†?Œ
		//?–´ì©”ìˆ˜ ?—†?´ ?›?†Œ?—ê²? ë¹„êµë¥? ë§¡ê¸°?Š”ê²? ?•„?‹ˆ?¼, ?Œ?‹¨?˜ ê¸°ë¶„?¸ Comparatorë¥? ?„£?–´?„œ 
		Arrays.sort(arr, new MyComparator());
		print(arr);
	}
	
	private static void print(int[][] arr) {
		for(int[] is : arr) {
			System.out.println(Arrays.toString(is));
		}
	}

}
