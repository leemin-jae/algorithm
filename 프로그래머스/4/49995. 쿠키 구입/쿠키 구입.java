import java.util.*;
class Solution {
    public int solution(int[] cookie) {


        int leftSum = Arrays.stream(cookie).sum();
        int rightSum = 0;
        int mid = cookie.length;
        int max = -1;
        while(mid > 0){
            mid--;

            leftSum -= cookie[mid];
            rightSum += cookie[mid];

            int right = cookie.length-1;
            int left = 0;

            int tmpRightSum = rightSum;
            int tmpLeftSum = leftSum;
            while (true) {
                if (tmpRightSum == tmpLeftSum) {
                    max = Math.max(max, tmpRightSum);
                    break;
                }else if (tmpLeftSum < tmpRightSum){
                    tmpRightSum -= cookie[right];
                    right--;
                }else{
                    tmpLeftSum -= cookie[left];
                    left++;
                }
            }
        }


        return max;
    }
}