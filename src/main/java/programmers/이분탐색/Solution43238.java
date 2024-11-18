// https://school.programmers.co.kr/learn/courses/30/lessons/43238?language=java
class Solution_43238 {
    public long solution(int n, int[] times) {
        long low = 1;  // 최소 시간은 1분
        long high = (long) n * times[times.length - 1];  // 최대 시간은 가장 느린 심사관이 모든 사람을 처리할 때

        // 이진 탐색
        while (low <= high) {
            long mid = (low + high) / 2;  // 중간 시간 계산
            long totalPeople = 0;

            // 주어진 시간(mid)에서 각 심사대가 처리할 수 있는 사람의 수를 구한다
            for (int time : times) {
                totalPeople += mid / time;  // 해당 심사관이 처리할 수 있는 사람 수
            }

            // 처리할 수 있는 사람이 n명 이상이면, 시간을 더 줄여볼 수 있다
            if (totalPeople >= n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;  // 최종적으로 최소 시간을 반환
    }
}
