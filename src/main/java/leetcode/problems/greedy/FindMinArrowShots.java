/*
https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.

Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

Example 1:
Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
*/
class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // 풍선을 xend 기준으로 정렬 (최대한 겹쳐서 터뜨릴 수 있도록)
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // 첫 번째 화살
        int lastArrowPosition = points[0][1]; // 첫 번째 화살의 위치 (첫 번째 풍선의 끝)
        for (int i = 1; i < points.length; i++) {
            // 현재 풍선의 시작점이 마지막 화살 위치보다 크면 새로운 화살 필요
            if (points[i][0] > lastArrowPosition) {
                arrows++; // 새로운 화살 추가
                lastArrowPosition = points[i][1]; // 화살을 현재 풍선의 끝에 위치
            }
        }

        return arrows;
    }
}
