package Implementation.silver.Q5635;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][2];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            arr[i][1] = line[0];
            arr[i][0] = line[3] + (line[2].length() == 1 ? "0" + line[2] : line[2]) + (line[1].length() == 1 ? "0" + line[1] : line[1]);
        }
        Arrays.sort(arr, (o1, o2) -> {
            return o2[0].compareTo(o1[0]);
        });
        bw.write(arr[0][1] + "\n" + arr[n-1][1]);
        bw.flush();
        br.close();
        bw.close();
    }
}
