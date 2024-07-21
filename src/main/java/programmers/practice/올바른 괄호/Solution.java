import java.util.*;
class Solution {
    boolean solution(String s) {
        // 스택을 이용하여 괄호 짝을 맞춤
        Stack<Character> stack = new Stack<>();

        // 문자열의 각 문자에 대해 처리
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // 여는 괄호는 스택에 추가
                stack.push(c);
            } else if (c == ')') {
                // 닫는 괄호는 스택에서 여는 괄호를 꺼내어 짝을 맞춤
                if (stack.isEmpty() || stack.pop() != '(') {
                    // 스택이 비어있거나 짝이 맞지 않으면 올바르지 않은 괄호
                    return false;
                }
            }
        }

        // 모든 처리가 끝난 후 스택이 비어있으면 올바른 괄호, 비어있지 않으면 올바르지 않은 괄호
        return stack.isEmpty();
    }
}
