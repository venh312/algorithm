package Implementation.silver.Q1475;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = br.readLine();
        int[] arr = new int[10];
        for (char c : n.toCharArray()) {
            int num = c - '0';
            if (num == 9)
                num = 6;
            ++arr[num];
        }
        arr[6] = (arr[6] / 2) + (arr[6] % 2);
        Arrays.sort(arr);
        bw.write(arr[9] + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
