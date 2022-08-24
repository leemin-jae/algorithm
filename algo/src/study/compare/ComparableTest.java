package study.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableTest {
	private static class StudentComparator implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			return -1*(o1.no - o2.no);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] student = new Student[] {
			new Student(1,10),
			new Student(5,52),
			new Student(2,100),
			new Student(4,52),
			new Student(3,80)
		};
		
		System.out.println("=========? •? ¬ ? „ ==========");
		System.out.println(Arrays.toString(student));
		
		//comparable : ?ê¸? ??‹ ê³? ???›?†Œ ë¹„êµ
		//comparable?´ ?—†?œ¼ë©? ?—?Ÿ¬ ë°œìƒ
		//comparable implements ë°? compareTo() ?¬? •?˜ ?•„?ˆ˜
		// return?— ?„¸?…?¼?„œ ? •? ¬ ?ˆ˜?–‰
		Arrays.sort(student);
		
		System.out.println("=========Comparable ê°ì²´?— êµ¬í˜„ ?™„ë£?, ?˜¤ë¦„ì°¨?ˆœ ==========");
		System.out.println(Arrays.toString(student));
		
		
		System.out.println("=========Comparator ?‚¬?š©, ?‚´ë¦¼ì°¨?ˆœ ==========");
		Arrays.sort(student, new StudentComparator());
		System.out.println(Arrays.toString(student));
		
		
		System.out.println("=========Comparator ?¼?šŒ?„±, ? ?ˆ˜ ?‚´ë¦¼ì°¨?ˆœ ==========");
		Arrays.sort(student, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o2.score - o1.score;
			}
		});
		
		System.out.println(Arrays.toString(student));
		
		System.out.println("=========Comparator ?¼?šŒ?„±, ? ?ˆ˜ ?˜¤ë¦„ì°¨?ˆœ ==========");
		//?Œ?‹¤?‹?
		Arrays.sort(student, (o1,o2) -> o1.score - o2.score );
		System.out.println(Arrays.toString(student));
	}

}
