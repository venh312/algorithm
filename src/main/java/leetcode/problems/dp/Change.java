/*
https://leetcode.com/problems/coin-change-ii/description/

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
다양한 액면가의 동전을 나타내는 정수 배열 동전과 총 금액을 나타내는 정수 금액이 주어집니다.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
You may assume that you have an infinite number of each kind of coin.
그 금액을 구성하는 조합의 수를 반환하세요. 그 금액을 동전의 조합으로 충당할 수 없다면, 0을 반환하세요.

The answer is guaranteed to fit into a signed 32-bit integer.

Example 1:
Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:
Input: amount = 10, coins = [10]
Output: 1
*/
class Change {
  public int change(int amount, int[] coins) {
      int[] dp = new int[amount + 1];
      dp[0] = 1; // 0원을 만들 수 있는 방법은 아무 동전도 사용하지 않는 1가지

      for (int coin : coins) { // 동전 하나씩 처리
          for (int i = coin; i <= amount; i++) {
              dp[i] += dp[i - coin]; // 현재 금액에서 해당 동전을 뺀 금액의 조합 수를 더함
          }
      }
      return dp[amount]; // 최종적으로 amount를 만드는 조합 수 반환
  }
}
