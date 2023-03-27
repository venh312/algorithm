package etc.Q10872;

import java.io.*;

public class Main {
    static int factorial(int n, int result) {
        if (n == 0) return result;
        return n * factorial(n - 1, n);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int answer = factorial(n, 0);
        bw.write((answer == 0 ? 1 : answer) + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
