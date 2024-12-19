/*
https://leetcode.com/problems/restore-ip-addresses/

A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s.

You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

Example 1:
Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]

Example 2:
Input: s = "0000"
Output: ["0.0.0.0"]

Example 3:
Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, "", result);
        return result;
    }

    private void backtrack(String s, int index, int segment, String current, List<String> result) {
        // 종료 조건: 4개의 segment를 만들었고 문자열을 다 사용한 경우
        if (segment == 4 && index == s.length()) {
            result.add(current);
            return;
        }

        // 종료 조건: segment가 4개를 초과하거나 index가 문자열을 초과한 경우
        if (segment > 4 || index >= s.length()) {
            return;
        }

        // 최대 3자리 숫자까지 시도
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break; // 범위를 초과한 경우 종료

            String part = s.substring(index, index + len);
            if (isValid(part)) {
                // 점(`.`)을 추가할지 결정
                String next = segment == 0 ? part : current + "." + part;
                backtrack(s, index + len, segment + 1, next, result);
            }
        }
    }

    private boolean isValid(String part) {
        if (part.length() > 1 && part.startsWith("0")) return false; // 선행 0이 있는 경우
        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255;
    }
}
