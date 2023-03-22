package etc.Q10798;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[][] arr = new String[5][15];
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++)
                arr[i][j] = String.valueOf(s.charAt(j));
        }
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 5; j++)
                bw.write(arr[j][i] == null ? "" : arr[j][i]);
        bw.flush();
        br.close();
        bw.close();
    }
}
