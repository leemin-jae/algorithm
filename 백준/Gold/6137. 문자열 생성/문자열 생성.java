import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static char Map[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        Map = new char[N];
        for(int i = 0 ; i <  N ;i ++){
            Map[i] = br.readLine().charAt(0);
        }

        int left = 0;
        int right = Map.length-1;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(left <= right){

//            if(Map[left] > Map[right]){
//                sb.append(Map[right]);
//                right--;
//            }else if(Map[left] < Map[right]){
//                sb.append(Map[left]);
//                left++;
//            }else if(Map[left] == Map[right]){
//                if(Map[left+1] > Map[right-1]){
//                    sb.append(Map[right]);
//                    right--;
//                }else{
//                    sb.append(Map[left]);
//                    left++;
//                }
//            }
            boolean flag = check(left , right);
            if(flag){
                sb.append(Map[right]);
                right--;
            }else{
                sb.append(Map[left]);
                left++;
            }

            i++;
            if(i%80 == 0){
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());

    }
    public static boolean check(int left, int right){
        boolean flag = false;
        if(Map[left] > Map[right]){
            flag = true;
        }else if(Map[left] < Map[right]){

        }else if(Map[left] == Map[right] && left < right){
            flag = check(left+1, right-1);
        }
        return flag;
    }

}