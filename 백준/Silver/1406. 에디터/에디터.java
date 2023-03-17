import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        LinkedList<Character> list = new LinkedList<>();
        for(int i  = 0 ; i < s.length() ; i++){
            list.add(s.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator();
        while(iter.hasNext()) {
            iter.next();
        }

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++){
            String now = br.readLine();
            char check = now.charAt(0);

            if(check == 'P'){
                iter.add(now.charAt(2));
            }else if(check == 'L'){
                if(iter.hasPrevious())
                    iter.previous();
            }else if(check == 'D'){
                if(iter.hasNext())
                    iter.next();
            }else{
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            }
        }

        for(Character c : list){
            bw.write(c);
        }
        bw.flush();
        bw.close();
    }


}