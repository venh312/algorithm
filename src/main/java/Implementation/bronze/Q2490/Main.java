package Implementation.bronze.Q2490;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 3; i++) {
            Map<String, Integer> hashMap = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                String s = st.nextToken();
                hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
            }
            int a = hashMap.getOrDefault("0", 0);
            int b = hashMap.getOrDefault("1", 0);
            if (a == 1 && b == 3)
                bw.write("A\n");
            else if (a == 2 && b == 2)
                bw.write("B\n");
            else if (a == 3 && b == 1)
                bw.write("C\n");
            else if (a == 4)
                bw.write("D\n");
            else if (b == 4)
                bw.write("E\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
