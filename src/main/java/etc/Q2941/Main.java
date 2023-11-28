package etc.Q2961;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        String[] alphabet = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        for (String s : alphabet)
            input = input.replace(s, "#");

        int count = 0;
        for (int i = 0; i < input.length(); i++)
            if (input.charAt(i) == '#') ++count;
        
        input = input.replace("#", "");
        bw.write((count + input.length()) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
