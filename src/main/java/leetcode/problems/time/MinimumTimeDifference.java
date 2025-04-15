/*
http://leetcode.com/problems/minimum-time-difference/

Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.

Example 1:
Input: timePoints = ["23:59","00:00"]
Output: 1

Example 2:
Input: timePoints = ["00:00","23:59","00:00"]
Output: 0
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        Set<String> timeSet = new HashSet<>();
        
        // 중복 시간 체크
        for (String time : timePoints) {
            if (!timeSet.add(time)) {
                // 중복된 시간이 있으면 바로 0을 반환
                return 0;
            }
        }

        List<Integer> minutes = new ArrayList<>();

        // HH:MM을 분(minute) 단위로 변환
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            minutes.add(hour * 60 + minute);
        }

        // 정렬
        Collections.sort(minutes);

        int minDiff = Integer.MAX_VALUE;

        // 인접한 시간 차이 비교
        for (int i = 1; i < minutes.size(); i++) {
            minDiff = Math.min(minDiff, minutes.get(i) - minutes.get(i - 1));
        }

        // 원형 시계이므로 마지막-처음도 비교 (24시간 = 1440분)
        int circularDiff = 1440 - minutes.get(minutes.size() - 1) + minutes.get(0);
        minDiff = Math.min(minDiff, circularDiff);

        return minDiff;
    }

    // 테스트
    public static void main(String[] args) {
        MinimumTimeDifference sol = new MinimumTimeDifference();

        List<String> example1 = Arrays.asList("23:59", "00:00");
        System.out.println("Example 1 Output: " + sol.findMinDifference(example1)); // 1

        List<String> example2 = Arrays.asList("00:00", "23:59", "00:00");
        System.out.println("Example 2 Output: " + sol.findMinDifference(example2)); // 0
    }
}
