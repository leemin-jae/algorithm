package algo.Baek;

import java.util.Scanner;

public class Baek17478 {
    static int rep = 0;

    static void p(int a) {
        for (int i = 0; i < a; i++) {
            System.out.print("____");
        }
    }

    static void JH(int a) {

        if (a == 0) {
            p(rep);
            System.out.println("\"?���??��?���? 뭔�??��?\"");
            p(rep);
            System.out.println("\"?���??��?��?�� ?���? ?��?��?�� ?��출하?�� ?��?��?��?��\"");
            return;
        }
        p(rep);
        System.out.println("\"?���??��?���? 뭔�??��?\"");
        p(rep);
        System.out.println("\"?�� ?��?��보게. ?��?��?��?�� ?�� ?�� �???기에 ?��?��?�� 모든 �??��?�� ?��?��?�� ?��?��?�� ?��?��?��.");
        p(rep);
        System.out.println("마을 ?��?��?��?? 모두 �? ?��?��?���? ?��많�? 질문?�� ?���?, 모두 �??���?�? ???��?�� 주었�?.");
        p(rep);
        System.out.println("그의 ?��?? ??�?�? ?��?��?���? ?��?��. 그런?�� ?��?�� ?��, �? ?��?��?���? ?�� ?��비�? 찾아???�� 물었?��.\"");

        rep += 1;
        JH(a - 1);

        p(rep);
        System.out.println("?���? ?���??��??�?.");

        rep -= 1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);


        int a = sc.nextInt();


        System.out.println("?��?�� ?�� 컴퓨?��공학�? ?��?��?�� ?��명한 교수?��?�� 찾아�? 물었?��.");
        //System.out.println("?���??��?���? 뭔�??��?");

        JH(a);
        System.out.println("?���? ?���??��??�?.");


    }

}
