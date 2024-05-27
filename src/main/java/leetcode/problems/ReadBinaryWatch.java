package leetcode.problems;

/*
A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.

For example, the below binary watch reads "4:51".


Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.

The hour must not contain a leading zero.

For example, "01:00" is not valid. It should be "1:00".
The minute must consist of two digits and may contain a leading zero.

For example, "10:2" is not valid. It should be "10:02".
 

Example 1:
Input: turnedOn = 1
Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]

Example 2:
Input: turnedOn = 9
Output: []
*/
class ReadBinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        // 0부터 11까지의 시간(hour)와 0부터 59까지의 분(minute)을 순회합니다.
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                // 현재 시간과 분에서 켜진 LED의 수를 계산합니다.
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    // 유효한 시간 형식으로 추가합니다.
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }
        
        return result;
    }
}
