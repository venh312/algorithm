import java.util.*;
class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String str : sArr) {
            int sInt = Integer.parseInt(str);
            if (min > sInt) {
                min = sInt;
            }
            if (max < sInt) {
                max = sInt;
            }
        }
        return min + " " + max;
    }
}
