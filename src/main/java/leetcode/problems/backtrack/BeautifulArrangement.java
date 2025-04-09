/*
https://leetcode.com/problems/beautiful-arrangement/description/

Suppose you have n integers labeled 1 through n.
A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
n개의 정수가 1부터 n까지 표시되어 있다고 가정해 보겠습니다.
n개의 정수 퍼머(1-indexed)의 순열은 모든 i(1 <= i <= n)에 대해 다음 중 하나가 참일 경우 아름다운 배열로 간주됩니다

perm[i] is divisible by i.
i is divisible by perm[i].
Given an integer n, return the number of the beautiful arrangements that you can construct.
정수 n이 주어졌을 때, 구성할 수 있는 아름다운 배열의 수를 반환하세요.

Example 1:
Input: n = 2
Output: 2
Explanation:
The first beautiful arrangement is [1,2]:
    - perm[1] = 1 is divisible by i = 1
    - perm[2] = 2 is divisible by i = 2
The second beautiful arrangement is [2,1]:
    - perm[1] = 2 is divisible by i = 1
    - i = 2 is divisible by perm[2] = 1
 */
public class BeautifulArrangement {

    int count = 0;

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        backtrack(n, 1, visited);
        return count;
    }

    private void backtrack(int n, int pos, boolean[] visited) {
        if (pos > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                visited[i] = true;
                backtrack(n, pos + 1, visited);
                visited[i] = false; // 백트래킹
            }
        }
    }

    public static void main(String[] args) {
        BeautifulArrangement solver = new BeautifulArrangement();
        int result = solver.countArrangement(2);
        System.out.println(result); // 출력: 1
    }
}
