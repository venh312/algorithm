package Implementation.silver.Q1316;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int answer = n;
        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            boolean[] alphabet = new boolean[26];
            for (int j = 0; j < st.length()-1; j++) {
                if (st.charAt(j) != st.charAt(j+1)) {
                    if (alphabet[st.charAt(j + 1) - 'a']) {
                        answer--;
                        break;
                    }
                }
                alphabet[st.charAt(j) - 'a'] = true;
            }
        }
        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
