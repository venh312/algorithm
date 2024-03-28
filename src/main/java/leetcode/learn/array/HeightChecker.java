package leetcode.learn.array;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
        int[] heights = {5, 1, 2, 3, 4};
        heightChecker(heights);
    }

    public static int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];
        System.arraycopy(heights, 0, expected, 0, heights.length); // 기대 순서를 복사

        // 기대 순서를 오름차순으로 정렬
        Arrays.sort(expected);

        int count = 0;
        // 현재 순서와 기대 순서를 비교하여 다른 인덱스 수 계산
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }

        return count;
    }
}
