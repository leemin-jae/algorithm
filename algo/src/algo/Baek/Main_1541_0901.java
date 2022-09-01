package algo.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1541_0901 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		String number[] = line.split("-");

		int sum = 0;

//		String a = "55";
//		System.out.println(a.contains("+"));
//		a.split("+");
//		

		if (number[0].contains("+")) {
			for (String l : number[0].split("\\+")) {
				sum += Integer.parseInt(l);
			}
		} else {
			sum = Integer.parseInt(number[0]);
		}

		for (int i = 1; i < number.length; i++) {
			int num = 0;

			if (number[i].contains("+")) {
				String [] now = number[i].split("\\+");
				for (String l : now) {
					num += Integer.parseInt(l);
				}
			} else {
				num = Integer.parseInt(number[i]);
			}

			sum -= num;

		}

		System.out.println(sum);
	}

}
