package etc.Q10988;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder str = new StringBuilder(br.readLine());
        bw.write((str.toString().equals(str.reverse().toString()) ? 1 : 0) + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
