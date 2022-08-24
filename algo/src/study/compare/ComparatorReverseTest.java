package study.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorReverseTest {
	//Comparator?�� reverseOrder()메서?�� ?��?��
	// ?��?�� ?��?��?��?�� ?��?��?���? 바꿔주는 메서?��, 기본?? ?��림차?��?���? 바꿔�?.
	public static void main(String[] args) {
		// API?��?�� ?��?�� ?��?�� Integer?�� 메서?�� ?��?��
		Integer[] arr = new Integer[] {4,3,7,5,10};
		System.out.println("========?��?�� ?�� : " + Arrays.toString(arr));
		Arrays.sort(arr, Comparator.reverseOrder());
		System.out.println("========?��?�� ?�� : " +Arrays.toString(arr));
		
		//?���? ?��?��?�� ?��?��?��?
		Student[] student = new Student[] {
				new Student(1,10),
				new Student(5,52),
				new Student(2,100),
				new Student(4,52),
				new Student(3,80)
		};
		
		System.out.println("========?��?�� ?�� : " + Arrays.toString(student));
		Arrays.sort(student, Comparator.reverseOrder());
		System.out.println("========?��?�� ?�� : " +Arrays.toString(student));
		

		
	}

}
