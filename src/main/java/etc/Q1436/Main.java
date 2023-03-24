package etc.Q1436;
import java.io.*;
public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int num = 666;
    int count = 1;
    while (n != count) {
      ++num;
      if (String.valueOf(num).contains("666")) ++count;
    }
    bw.write(num + "");
    bw.flush();
    br.close();
    bw.close();
  }
}
