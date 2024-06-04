package leetcode.problems;

/*
A web developer needs to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:

The area of the rectangular web page you designed must equal to the given target area.
The width W should not be larger than the length L, which means L >= W.
The difference between length L and width W should be as small as possible.
Return an array [L, W] where L and W are the length and width of the web page you designed in sequence.

Example 1:
Input: area = 4
Output: [2,2]
Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1]. 
But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.

Example 2:
Input: area = 37
Output: [37,1]

Example 3:
Input: area = 122122
Output: [427,286]
*/
class ConstructRectangle {
    public int[] constructRectangle(int area) {
         int w = (int) Math.sqrt(area); // 너비의 초기 값을 면적의 제곱근으로 설정
        while (area % w != 0) { // 면적이 w로 나누어 떨어지지 않으면 w를 줄임
            w--;
        }
        int l = area / w; // 길이를 구함
        return new int[] {l, w}; // 길이와 너비를 배열로 반환
    }
}
