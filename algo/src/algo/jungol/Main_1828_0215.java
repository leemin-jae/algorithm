package algo.jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1828_0215 {
	static class Temp implements Comparable<Temp>{
		int low;
		int high;
		
		public Temp(int low, int high) {
			this.low = low;
			this.high = high;
		}
		@Override
		public int compareTo(Temp o) {
			// TODO Auto-generated method stub
			return (this.high == o.high)? -1*(this.low - o.low) : -1*( this.high - o.high);   //�삤由꾩감�닚�쑝濡� �젙�젹
		}



	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Temp[] m = new Temp[N];
		
		for (int i = 0; i < N; i++) {
			m[i] = new Temp(sc.nextInt(),sc.nextInt());
		}
		
		Arrays.sort(m);     // �엯�젰諛쏆� 諛곗뿴�쓣 �넂�� 媛믪쓣 �삤由꾩감�닚�쑝濡� �젙�젹
		
		int t_low = m[0].low;           // 泥ル쾲吏� 媛믪쓣 湲곗��쑝濡� �젙�븿
		int cnt = 1;                    // �깋�옣怨� 媛쒖닔, �떆�옉�븷�븣 1媛�
		for(int i = 1 ; i < m.length ; i ++) { 
			//if(i == m.length) break;
			if(t_low > m[i].high) {                   //吏�湲� �깋�옣怨좉� 媛��뒫�븳 媛��옣 �궙�� �삩�룄媛� �떎�쓬 �빟�뭹湲곗��쓽 理쒕�媛� 蹂대떎 �넂�쓣 寃쎌슦 
				cnt++;                                // �깋�옣怨� +1
				t_low = m[i].low;                     // �깋�옣怨� 湲곗� �삩�룄瑜� �씠踰� �빟�뭹�쓽 理쒖� �삩�룄濡� 蹂�寃�
				continue;
			}else if(t_low < m[i].low ) {             //�떎�쓬 �빟�뭹 理쒖��삩�룄媛� 湲곗� �삩�룄蹂대떎 �넂�쓣 寃쎌슦  
				t_low = m[i].low;					  //湲곗� �삩�룄瑜� 以꾩뿬以�
			}
		}

		System.out.println(cnt);
		
	}
}
