package study.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorReverseTest {
	//Comparator? reverseOrder()λ©μ? ?¬?©
	// ??¬ ? ? ¬?? ?­??Όλ‘? λ°κΏμ£Όλ λ©μ?, κΈ°λ³Έ?? ?΄λ¦Όμ°¨??Όλ‘? λ°κΏμ€?.
	public static void main(String[] args) {
		// API? ? ??΄ ?? Integer? λ©μ? ?¬?©
		Integer[] arr = new Integer[] {4,3,7,5,10};
		System.out.println("========? ? ¬ ?  : " + Arrays.toString(arr));
		Arrays.sort(arr, Comparator.reverseOrder());
		System.out.println("========? ? ¬ ? : " +Arrays.toString(arr));
		
		//?΄κ°? ? ?? ?΄??€?
		Student[] student = new Student[] {
				new Student(1,10),
				new Student(5,52),
				new Student(2,100),
				new Student(4,52),
				new Student(3,80)
		};
		
		System.out.println("========? ? ¬ ?  : " + Arrays.toString(student));
		Arrays.sort(student, Comparator.reverseOrder());
		System.out.println("========? ? ¬ ? : " +Arrays.toString(student));
		

		
	}

}
