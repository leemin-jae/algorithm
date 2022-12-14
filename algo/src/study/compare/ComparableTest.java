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
		
		System.out.println("=========? ? ¬ ?  ==========");
		System.out.println(Arrays.toString(student));
		
		//comparable : ?κΈ? ?? κ³? ???? λΉκ΅
		//comparable?΄ ??Όλ©? ??¬ λ°μ
		//comparable implements λ°? compareTo() ?¬? ? ??
		// return? ?Έ??Ό? ? ? ¬ ??
		Arrays.sort(student);
		
		System.out.println("=========Comparable κ°μ²΄? κ΅¬ν ?λ£?, ?€λ¦μ°¨? ==========");
		System.out.println(Arrays.toString(student));
		
		
		System.out.println("=========Comparator ?¬?©, ?΄λ¦Όμ°¨? ==========");
		Arrays.sort(student, new StudentComparator());
		System.out.println(Arrays.toString(student));
		
		
		System.out.println("=========Comparator ?Ό??±, ? ? ?΄λ¦Όμ°¨? ==========");
		Arrays.sort(student, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o2.score - o1.score;
			}
		});
		
		System.out.println(Arrays.toString(student));
		
		System.out.println("=========Comparator ?Ό??±, ? ? ?€λ¦μ°¨? ==========");
		//??€??
		Arrays.sort(student, (o1,o2) -> o1.score - o2.score );
		System.out.println(Arrays.toString(student));
	}

}
