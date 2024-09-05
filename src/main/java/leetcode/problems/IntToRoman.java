/**
 https://leetcode.com/problems/integer-to-roman/

 Seven different symbols represent Roman numerals with the following values:

 Symbol	Value
 I	    1
 V	    5
 X	    10
 L	    50
 C	    100
 D	    500
 M	    1000
 Roman numerals are formed by appending the conversions of decimal place values from highest to lowest.
 로마 숫자는 소수점 자리 수 값을 가장 높은 자리 수에서 가장 낮은 자리 수로 변환하여 형성됩니다.

 Converting a decimal place value into a Roman numeral has the following rules:
 소수점 자릿값을 로마 숫자로 변환하는 규칙은 다음과 같습니다:

 If the value does not start with 4 or 9,
 만약에 값이 4 또는 9로 시작하지 않으면,
 select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result,
 입력에서 뺄 수 있는 최대값의 기호를 선택하고 해당 기호를 결과에 추가합니다,

 subtract its value, and convert the remainder to a Roman numeral.
 값을 빼고 나머지를 로마 숫자로 변환합니다.

 If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from
 the following symbol, for example,
 값이 4 또는 9로 시작하는 경우, 예를 들어

 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX.
 4는 1(I)이 5(V)보다 작습니다: IV, 9는 1(I)이 10(X)보다 작습니다: IX.

 Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
 4(IV), 9(IX), 40(XL), 90(XC), 400(CD) 및 900(CM)의 감산 형식만 사용됩니다.


 Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10.
 You cannot append 5 (V), 50 (L), or 500 (D) multiple times.
 10의 배수를 나타내기 위해 최대 3번 연속으로 10(I, X, C, M)의 거듭제곱만 추가할 수 있습니다.
 5(V), 50(L) 또는 500(D)을 여러 번 추가할 수 없습니다.

 If you need to append a symbol 4 times use the subtractive form.
 기호를 4번 추가해야 하는 경우 감산 형식을 사용합니다.


 Given an integer, convert it to a Roman numeral.

 Example 1:
 Input: num = 3749
 Output: "MMMDCCXLIX"
 Explanation:
 3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
 700 = DCC as 500 (D) + 100 (C) + 100 (C)
 40 = XL as 10 (X) less of 50 (L)
 9 = IX as 1 (I) less of 10 (X)
 Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places

 Example 2:
 Input: num = 58
 Output: "LVIII"
 Explanation:
 50 = L
 8 = VIII
 Example 3:

 Input: num = 1994
 Output: "MCMXCIV"
 Explanation:
 1000 = M
 900 = CM
 90 = XC
 4 = IV
*/
class IntToRoman {
    public String intToRoman(int num) {
        Map<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");

        int[] romanArr = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        StringBuilder sb = new StringBuilder();
        for (int key : romanArr) {
            if (num == 0) break;
            int result = num / key;
            num %= key;
            for (int i = 0; i < result; i++) {
                sb.append(romanMap.get(key));
            }
        }

        return sb.toString();
    }
}
