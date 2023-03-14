package Implementation.bronze.Q1110;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int origin = Integer.parseInt(br.readLine());
        int tmp = origin;
        int answer = 0;
        while (true) {
            int left = tmp / 10;
            int right = tmp % 10;
            tmp = right * 10 + (left + right) % 10;
            ++answer;
            if (origin == tmp) break;
        }
        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
