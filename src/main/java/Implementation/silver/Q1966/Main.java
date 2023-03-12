package Implementation.silver.Q1966;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < total; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            for (int j = 0; j < n; j++)
                q.offer(Integer.valueOf(st.nextToken()));

            int count = 0;
            while (!q.isEmpty()) {
                int out = q.poll();
                boolean isBreak = false;

                for (int k : q) {
                    if (out < k) {
                        q.offer(out);
                        if (m != 0)
                            m--;
                        else
                            m = q.size() - 1;
                        isBreak = true;
                        break;
                    }
                }

                if (!isBreak) {
                    count++;
                    if (m == 0) {
                        bw.write(count + "\n");
                        break;
                    }
                    m--;
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
