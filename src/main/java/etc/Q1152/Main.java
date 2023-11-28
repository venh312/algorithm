package etc.Q1152;
import java.io.*;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine().trim();
        if (word.isEmpty()) {
            bw.write("0");
        } else {
            String[] wordArr = word.trim().split(" ");
            bw.write(Arrays.stream(wordArr).count() + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
