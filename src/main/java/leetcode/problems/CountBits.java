package leetcode.problems;

/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i]
is the number of 1's in the binary representation of i.

Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
*/
class CountBits {
    /*
    2진수 1의 개수를 loop를 사용해서 찾는방법 - worst
    */
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for (int i = 1; i<= n; i++) {
            int value = i;
            int count = 0;
            while (value > 0) {
                if (value % 2 != 0) count++;
                value /= 2;
            }
            arr[i] = count;
        }
        return arr;
    }

    /*
    동적 프로그래밍을 사용한 방법 - best
    i가 짝수인 경우, i의 이진 표현에서 1의 개수는 i/2의 이진 표현에서 1의 개수와 같습니다.
    i가 홀수인 경우, i의 이진 표현에서 1의 개수는 i/2의 이진 표현에서 1의 개수에 1을 더한 것과 같습니다
    */
    public int[] countBits2(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                ans[i] = ans[i / 2];
            } else {
                ans[i] = ans[i / 2] + 1;
            }
        }

        return ans;
    }
}
