/**
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1],
then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21
*/
class ReverseInteger {
    public int reverse(int x) {
        if (x >= 0 && x < 10) return x;

        int result = 0;
        int len = String.valueOf(Math.abs(x)).length();

        while (x != 0) {
            int mod = x % 10;
            result += (mod * Math.pow(10, --len));
            x /= 10;
        }

        if (result == -2147483648 || result == 2147483647) return 0;

        return result;
    }
}
