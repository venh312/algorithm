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
