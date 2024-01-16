class Solution {

    static boolean prime[] = new boolean[10000001];

    static public void init(){
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i < prime.length ;i++){
            if (!prime[i]){
                for (int j = i+i; j < prime.length; j+=i) {
                    prime[j] = true;
                }
            }
        }
    }
    public int solution(int n , int k) {
        init();
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while ( n != 0){
            sb.append(n%k);
            n = n/k;
        }
        String s = sb.reverse().toString();
//        System.out.println(s);
        String sp[] = s.split("0");
        for (String now : sp){
            if(now.length() == 0) continue;
            int num = Integer.parseInt(now);
//            int mul = 1;
//            for (int i = now.length() -1; i >= 0 ; i--) {
//                num += (now.charAt(i) - '0')*mul;
//                mul = mul*k;
//            }

//            System.out.println(num + " " + now);

            if(!prime[num]){

                answer++;
            }

        }


        return answer;
    }
}