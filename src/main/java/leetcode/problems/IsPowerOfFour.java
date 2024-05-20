package leetcode.problems;

/*
  Given an integer n, return true if it is a power of four.
  Otherwise, return false.
  An integer n is a power of four, if there exists an integer x such that n == 4x.

  Example 1:
  Input: n = 16
  Output: true

  Example 2:
  Input: n = 5
  Output: false

  Example 3:
  Input: n = 1
  Output: true

  정수 n이 주어지면 4의 거듭제곱이면 true를 반환한다.
  그렇지 않으면 거짓으로 돌려주세요.
  만약 n==4x가 되는 정수 x가 존재한다면 정수 n은 4의 거듭제곱이다.
*/
class IsPowerOfFour {
    // loop 사용 O
    public boolean isPowerOfFour(int n) {
    	if (n <= 0) {
    		return false;
    	}
    	while (n % 4 == 0) {
    		n /= 4;
    	}
    	return n == 1;
    }

    // loop 사용 X
    public boolean isPowerOfFour(int n) {
      // 1. n이 양수인지 확인
    	if (n <= 0) {
    		return false;
    	}
    	// 2. n이 2의 거듭제곱인지 확인 (2의 거듭제곱은 이진수로 1 하나와 나머지 0들로 이루어짐)
    	if ((n & (n - 1)) != 0) {
    		return false;
    	}
    	// 3. n이 4의 거듭제곱인지 확인 (4의 거듭제곱은 3으로 나눴을 때 나머지가 1)
    	return (n % 3 == 1);
    }
}
