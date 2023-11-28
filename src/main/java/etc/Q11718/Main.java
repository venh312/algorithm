package etc.Q11718;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
