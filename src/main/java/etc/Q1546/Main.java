package etc.Q1546;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Double[] arr = new Double[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Double.valueOf(st.nextToken());
        Arrays.sort(arr);
        bw.write(Arrays.stream(arr).mapToInt(Double::intValue).sum() / arr[n-1] * 100 / n + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
