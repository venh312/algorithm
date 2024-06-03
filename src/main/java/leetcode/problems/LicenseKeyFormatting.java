package leetcode.problems;

/*
  영숫자 문자와 대시로만 구성된 문자열로 표시되는 라이센스 키가 주어지고 문자열은 n + 1 그룹으로 n 개의 대시로 구분되며 정수 k도 부여됩니다.
  첫 번째 그룹을 제외하고 각 그룹이 k보다 짧을 수 있지만 적어도 하나의 문자를 포함해야 하는 정확히 k개의 문자를 포함하도록 문자열을 다시 포맷하고자 합니다.
  또한 두 그룹 사이에 대시가 삽입되어 있어야 하며 모든 소문자를 대문자로 변환해야 합니다.
  다시 포맷된 라이센스 키를 반환합니다.

  Example 1:
  Input: s = "5F3Z-2e-9-w", k = 4
  Output: "5F3Z-2E9W"
  문자열은 두 부분으로 나뉘었고 각 부분에는 4자가 있습니다.
  두 개의 추가 대시는 필요하지 않으며 제거할 수 있습니다.

  Example 2:
  Input: s = "2-5g-3-J", k = 2
  Output: "2-5G-3J"
  문자열이 세 부분으로 나뉘었는데, 위에서 언급한 것처럼 더 짧을 수 있기 때문에 각 부분은 첫 번째 부분을 제외하고 2자로 구성되어 있습니다.
*/
class LicenseKeyFormatting {
    // Runtime: 59 ms, faster than 28.43%
    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder(s.toUpperCase().replace("-", ""));

        int hyphen = (sb.length()-1) / k;
        int length = sb.length();

        for (int i = 0; i < hyphen; i++) {
            length -= k;
            sb.insert(length, "-");
        }

        return sb.toString();
    }

    // Runtime: 7 ms, faster than 99.04%
    public static String licenseKeyFormatting2(String s, int k) {
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '-') {
                cleaned.append(Character.toUpperCase(c));
            }
        }

        StringBuilder result = new StringBuilder();
        int length = cleaned.length();
        int firstGroupLength = length % k;
        int index = 0;

        if (firstGroupLength > 0) {
            result.append(cleaned.substring(0, firstGroupLength));
            index = firstGroupLength;
        }

        while (index < length) {
            if (result.length() > 0) {
                result.append('-');
            }
            result.append(cleaned.substring(index, index + k));
            index += k;
        }

        return result.toString();
    }
}
