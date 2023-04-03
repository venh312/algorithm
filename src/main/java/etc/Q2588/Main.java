package etc.Q2588;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();
        for (int i = b.length()-1; i >= 0; i--)
            bw.write(a * Integer.parseInt(String.valueOf(b.charAt(i))) + "\n");
        bw.write(a * Integer.parseInt(b) + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
