/**
 The string "PAYPALISHIRING" is written in a
 zigzag pattern on a given number of rows like
 this: (you may want to display this pattern in a fixed font for better legibility)
 문자열 "PAYPALISHIRING"은 다음과 같이 주어진 수의 행에 지그재그 패턴으로 작성됩니다.
 (더 잘 읽기 위해 이 패턴을 고정된 글꼴로 표시하는 것이 좋습니다.)

 P      A     H    N
 A  P  L  S  I  I  G
 Y      I      R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 그리고 "PHNAPLSSIIGYIR"을 한 줄 한 줄 읽어보세요
 문자열을 사용할 코드를 작성하고 몇 개의 행이 주어지면 이 변환을 수행합니다:

 Example 1:
 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"

 Example 2:
 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"
 Explanation:
 P             I           N
 A        L   S       I  G
 Y   A       H   R
 P             I

 Example 3:
 Input: s = "A", numRows = 1
 Output: "A"
*/
class Convert {
    public String convert(String s, int numRows) {
         // 예외 처리
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        
        // 각 행을 위한 StringBuilder 배열 초기화
        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        
        int currentRow = 0;
        boolean goingDown = false;
        
        // 문자열을 순회하며 지그재그 패턴을 구성
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            
            // 현재 행이 첫 번째 또는 마지막 행에 도달하면 방향 변경
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // 방향에 따라 현재 행을 증가 또는 감소
            currentRow += goingDown ? 1 : -1;
        }
        
        // 모든 행을 결합하여 최종 결과 문자열 생성
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
}
