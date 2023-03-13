package Implementation.silver.Q11866;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[n];
        StringBuilder sb = new StringBuilder("<");
        int length = 0, cnt = 0, index = 0;
        while (n != length) {
            int val = index % check.length;
            if (!check[val]) ++cnt;
            if (cnt == k) {
                cnt = 0;
                check[val] = true;
                ++length;
                sb.append(length == n ? val+1 : (val+1) + ", ");
            }
            ++index;
        }
        sb.append(">");
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
