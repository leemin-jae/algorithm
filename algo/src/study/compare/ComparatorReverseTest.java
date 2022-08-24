package study.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorReverseTest {
	//Comparator?— reverseOrder()ë©”ì„œ?“œ ?‚¬?š©
	// ?˜„?¬ ? •? ¬?—?„œ ?—­?ˆœ?œ¼ë¡? ë°”ê¿”ì£¼ëŠ” ë©”ì„œ?“œ, ê¸°ë³¸?? ?‚´ë¦¼ì°¨?ˆœ?œ¼ë¡? ë°”ê¿”ì¤?.
	public static void main(String[] args) {
		// API? •?˜ ?˜?–´ ?ˆ?Š” Integer?— ë©”ì„œ?“œ ?‚¬?š©
		Integer[] arr = new Integer[] {4,3,7,5,10};
		System.out.println("========? •? ¬ ? „ : " + Arrays.toString(arr));
		Arrays.sort(arr, Comparator.reverseOrder());
		System.out.println("========? •? ¬ ?›„ : " +Arrays.toString(arr));
		
		//?‚´ê°? ? •?˜?•œ ?´?˜?Š¤?
		Student[] student = new Student[] {
				new Student(1,10),
				new Student(5,52),
				new Student(2,100),
				new Student(4,52),
				new Student(3,80)
		};
		
		System.out.println("========? •? ¬ ? „ : " + Arrays.toString(student));
		Arrays.sort(student, Comparator.reverseOrder());
		System.out.println("========? •? ¬ ?›„ : " +Arrays.toString(student));
		

		
	}

}
