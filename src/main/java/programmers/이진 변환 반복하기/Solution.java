class Solution {
    public int[] solution(String s) {
      int recursionCount = 0;
      int recursionZeroCount = 0;
  
      while (!s.equals("1")) {
          int zeroCount = 0;
          StringBuilder sb = new StringBuilder();
  
          for (char c : s.toCharArray()) {
              if (c == '0') zeroCount++;
              else sb.append(c);
          }
  
          recursionCount++;
          recursionZeroCount += zeroCount;
  
          s = Integer.toBinaryString(sb.length());
      }
  
      return new int[]{ recursionCount, recursionZeroCount };
    }
}
