package datastructure.Q9012;

import java.io.*;

public class Main {
    static boolean isVPS(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(0) == ')' || s.charAt(s.length()-1) == '(') return false;
            if (s.charAt(i) == '(') ++cnt;
            if (s.charAt(i) == ')') --cnt;
            if (cnt < 0) return false;
        }
        return cnt == 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            bw.write((isVPS(br.readLine()) ? "YES" : "NO") + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
