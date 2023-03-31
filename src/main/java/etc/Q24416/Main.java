package etc.Q24416;

import java.io.*;

public class Main {
    static int cnt1 = 0;
    static int cnt2 = 0;
    static int[] arr;
    static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            ++cnt1;
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int fibonacci2(int n) {
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            ++cnt2;
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        fibonacci(n);
        fibonacci2(n);
        bw.write(cnt1 + " " + cnt2);
        bw.flush();
        br.close();
        bw.close();
    }
}
