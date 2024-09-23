/*
Given a string containing digits from 2-9 inclusive,
return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

"234"
["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]

"237"
["adp","adq","adr","ads","aep","aeq","aer","aes","afp","afq","afr","afs","bdp","bdq","bdr","bds","bep","beq","ber","bes","bfp","bfq","bfr","bfs","cdp","cdq","cdr","cds","cep","ceq","cer","ces","cfp","cfq","cfr","cfs"]
 */
class LetterCombinations {
    private static final HashMap<Character, String> digitToLetters = new HashMap<>();

    static {
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.isEmpty()) {
            return combinations;
        }
        backtrack("", digits, 0, combinations);
        return combinations;
    }

    private void backtrack(String combination, String digits, int index, List<String> combinations) {
        if (index == digits.length()) {
            combinations.add(combination);
            return;
        }
        
        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);
        
        for (char letter : letters.toCharArray()) {
            backtrack(combination + letter, digits, index + 1, combinations);
        }
    }
}
