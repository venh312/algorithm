package Implementation.bronze.Q8958;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int answer = 0;
            int cnt = 0;
            String str = br.readLine();
            String[] arr = str.split("");
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals("O"))
                    ++cnt;
                else
                    cnt = 0;
                answer += cnt;
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
