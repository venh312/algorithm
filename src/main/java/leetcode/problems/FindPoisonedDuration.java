package leetcode.problems;

/*
Our hero Teemo is attacking an enemy Ashe with poison attacks! When Teemo attacks Ashe, Ashe gets poisoned for a exactly duration seconds. More formally, an attack at second t will mean Ashe is poisoned during the inclusive time interval [t, t + duration - 1]. If Teemo attacks again before the poison effect ends, the timer for it is reset, and the poison effect will end duration seconds after the new attack.
You are given a non-decreasing integer array timeSeries, where timeSeries[i] denotes that Teemo attacks Ashe at second timeSeries[i], and an integer duration.
Return the total number of seconds that Ashe is poisoned.

Example 1:
Input: timeSeries = [1,4], duration = 2
Output: 4
Explanation: Teemo's attacks on Ashe go as follows:
- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
- At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
Ashe is poisoned for seconds 1, 2, 4, and 5, which is 4 seconds in total.

Example 2:
Input: timeSeries = [1,2], duration = 2
Output: 3
Explanation: Teemo's attacks on Ashe go as follows:
- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
- At second 2 however, Teemo attacks again and resets the poison timer. Ashe is poisoned for seconds 2 and 3.
Ashe is poisoned for seconds 1, 2, and 3, which is 3 seconds in total.
*/
class FindPoisonedDuration {
    // Runtime: 3 ms, faster than 73.20% 
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalDuration = 0;
        int n = timeSeries.length;

        for (int i = 0; i < n; i++) {
            // 현재 공격으로부터 독이 지속되는 시간을 계산합니다.
            int currentDuration = duration;
            if (i < n - 1) {
                // 다음 공격과의 시간 간격이 duration보다 작다면 그 차이만큼만 독이 지속됩니다.
                currentDuration = Math.min(timeSeries[i + 1] - timeSeries[i], duration);
            }
            // 현재 공격으로 인해 발생하는 독의 지속 시간을 더합니다.
            totalDuration += currentDuration;
        }

        return totalDuration;
    }
}
