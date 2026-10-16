import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> s = new HashSet<>();
        for(int n : nums){
            s.add(n);
        }
        int num = s.size();
        if(nums.length/2 <= num) return nums.length/2;
        else return num;
    }
}