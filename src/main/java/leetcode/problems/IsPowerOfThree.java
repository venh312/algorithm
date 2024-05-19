package leetcode.problems;

/*
Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.

Example 1:
Input: n = 27
Output: true
Explanation: 27 = 33

Example 2:
Input: n = 0
Output: false
Explanation: There is no x where 3x = 0.

Example 3:
Input: n = -1
Output: false
Explanation: There is no x where 3x = (-1).
*/
class IsPowerOfThree {
    // 반복문을 사용한 해결 방법
    public boolean isPowerOfThree(int n) {
      if (n <= 0) return false;
      
      while (n > 1) {
          if (n % 3 == 0) {
              n /= 3;    
          } else {
              return false;
          }
      }
      
      return true;
  }

  // 로그를 사용한 수학적 접근 해결 방법
  public boolean isPowerOfThree2(int n) {
      if (n <= 0) {
          return false;
      }
      double logResult = Math.log10(n) / Math.log10(3);
      return logResult == (int) logResult;
  }


  // 3의 최대 거듭제곱 값을 이용한 해결 방법
  public boolean IsPowerOfThree3(int n) {
      if (n <= 0) return false;
      
       // 32비트 정수 범위 내에서 3의 최대 거듭제곱 값을 찾기
      int maxInt = Integer.MAX_VALUE;
      int maxPowerOfThree = 1;
      
      // 3의 거듭제곱을 반복적으로 계산하면서 최대 값을 찾음
      while (maxPowerOfThree <= maxInt / 3) {
          maxPowerOfThree *= 3;
      }
      
      return maxPowerOfThree % n == 0;
  }
}
