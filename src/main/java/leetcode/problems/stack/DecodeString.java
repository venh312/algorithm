/*
https://leetcode.com/problems/decode-string/
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.
인코딩 규칙은 다음과 같습니다: k[encoded_string]. 여기서 사각 괄호 안의 인코딩_스트링은 정확히 k번 반복됩니다. k는 양의 정수임이 보장된다는 점에 유의하세요.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
Furthermore,
you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.
입력 문자열이 항상 유효하다고 가정할 수 있습니다.
추가적인 공백이 없고, 대괄호가 잘 형성되어 있습니다.
또한 원본 데이터에 숫자가 포함되어 있지 않으며, 숫자는 반복되는 숫자 k에 대해서만 해당한다고 가정할 수 있습니다.
예를 들어, 3a나 2[4]와 같은 입력은 없을 것입니다. 테스트 케이스는 출력 길이가 105를 초과하지 않도록 생성됩니다

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
*/
class DecodeString {
    public String decodeString(String s) {
        // 스택을 사용할 준비
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> result = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int currentNumber = 0;

        // 문자열을 하나씩 처리
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 숫자일 경우, k 값이 여러 자릿수일 수 있기 때문에 currentNumber에 계속 더함
                currentNumber = currentNumber * 10 + (c - '0');
            } else if (c == '[') {
                // '['을 만나면 현재까지의 문자열과 숫자를 스택에 넣고 초기화
                counts.push(currentNumber);
                result.push(currentString);
                currentString = new StringBuilder();
                currentNumber = 0;  // 숫자 초기화
            } else if (c == ']') {
                // ']'을 만나면 스택에서 꺼내고, 해당 문자열을 반복하여 합침
                StringBuilder temp = currentString;
                currentString = result.pop();
                int repeatCount = counts.pop();

                // temp 문자열을 repeatCount 만큼 반복하여 합침
                for (int i = 0; i < repeatCount; i++) {
                    currentString.append(temp);
                }
            } else {
                // 문자일 경우 현재 문자열에 추가
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
}
