import java.util.*;
/*
https://school.programmers.co.kr/learn/courses/30/lessons/181188
*/
class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int answer = 0;
        int lastIntercept = Integer.MIN_VALUE;
        
        // 1,4 > 4,5 > 3,7 > 4,8 > 5,12 > 11,13 > 10,14 
        for (int[] target : targets) {
            if (target[0] >= lastIntercept) {
                answer++;
                lastIntercept = target[1];
            }                    
        }
        
        return answer;
    }
}
