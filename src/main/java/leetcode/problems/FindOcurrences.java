/*
Given two strings first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.

Return an array of all the words third for each occurrence of "first second third".

Example 1:
Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
Output: ["girl","student"]

Example 2:
Input: text = "we will we will rock you", first = "we", second = "will"
Output: ["we","rock"]
*/
class FindOcurrences {
    public String[] findOcurrences(String text, String first, String second) {
        String[] textSplit = text.split(" ");
        String prev = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < textSplit.length; i++) {
            if (textSplit[i].equals(second)) {
                if (i > 0) {
                    if (textSplit[i-1].equals(first)) {
                        if (i+1 < textSplit.length) {
                            list.add(textSplit[i+1]);
                        }
                    }
                }
            }
        }
        
        return list.toArray(new String[0]);
    }
}
