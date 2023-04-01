package etc.Q2566;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        String coord = "";
        for (int i  = 0 ; i < 9; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                int val = Integer.parseInt(arr[j]);
                if (val > answer) {
                    coord = (i+1) + " " + (j+1);
                    answer = val;
                }
            }
        }
        bw.write(answer + "\n" + coord);
        bw.flush();
        br.close();
        bw.close();
    }
}
