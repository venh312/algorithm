package leetcode.problems;

/*
You are given a string sentence that consist of words separated by spaces. Each word consists of
lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
The rules of Goat Latin are as follows:

공백으로 구분된 단어로 구성된 문자열 문장이 주어집니다. 각 단어는 소문자와 대문자로만 구성됩니다.
문장을 "고트 라틴"(Pig Latin과 유사한 꾸며낸 언어)으로 전환하고자 합니다. 고트 라틴의 규칙은 다음과 같습니다:

If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.

For example, the word "apple" becomes "applema".
If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end,
then add "ma".
For example, the word "goat" becomes "oatgma".
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.

단어가 모음('a', 'e', 'i', 'o' 또는 'u')으로 시작하는 경우 단어 끝에 "ma"를 붙입니다.
    예를 들어, "사과"라는 단어는 "사과"가 됩니다.
단어가 자음으로 시작하는 경우(즉, 모음이 아닌) 첫 글자를 제거하고 끝에 추가한 다음 "마"를 추가합니다.
    예를 들어, "염소"라는 단어는 "귀리"가 됩니다.
문장에서 각 단어의 단어 색인당 1자씩 'a'를 추가합니다.
    예를 들어, 첫 번째 단어는 끝에 "a"가 추가되고, 두 번째 단어는 끝에 "aa"가 추가되는 등입니다.

For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
Return the final sentence representing the conversion from sentence to Goat Latin.

Example 1:
Input: sentence = "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

Example 2:
Input: sentence = "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa
hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
*/
class ToGoatLatin {
    //  Runtime: 1 ms, faster than 100.00%
    public String toGoatLatin(String sentence) {
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        int index = 1;

        for (String word : words) {
            char firstChar = Character.toLowerCase(word.charAt(0));

            if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u') {
                result.append(word);
            } else {
                result.append(word.substring(1)).append(word.charAt(0));
            }

            result.append("ma");
            for (int j = 0; j < index; j++) {
                result.append("a");
            }

            result.append(" ");
            index++;
        }

        return result.toString().trim();
    }
}
