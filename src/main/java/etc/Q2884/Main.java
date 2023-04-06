package etc.Q2884;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        m -= 45;
        if (m < 0) {
            --h;
            if (h < 0) h = 23;
            m = m + 60;
        }
        bw.write(h + " " + m);
        bw.flush();
        br.close();
        bw.close();
    }
}
