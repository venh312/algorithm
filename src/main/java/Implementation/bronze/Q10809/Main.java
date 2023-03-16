package Implementation.bronze.Q10809;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++)
            hashMap.put(word.charAt(i), i);
        for (int i = 97; i <= 122; i++)
            bw.write(hashMap.getOrDefault((char) i, -1) + " ");
        bw.flush();
        br.close();
        bw.close();
    }
}
