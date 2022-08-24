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
		System.out.println("==========?��?�� ?��==========");
		//?��기서 ?��?��?�� 1차원 배열 int[] <-- ?���? ?��?��, ?���? ?��?��?�� 기분 ?��무것?�� ?��?��
		//?��쩔수 ?��?�� ?��?��?���? 비교�? 맡기?���? ?��?��?��, ?��?��?�� 기분?�� Comparator�? ?��?��?�� 
		Arrays.sort(arr, new MyComparator());
		print(arr);
	}
	
	private static void print(int[][] arr) {
		for(int[] is : arr) {
			System.out.println(Arrays.toString(is));
		}
	}

}
