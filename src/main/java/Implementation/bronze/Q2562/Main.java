package Implementation.bronze.Q2562;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++)
            list.add(Integer.valueOf(br.readLine()));
        int val = list.stream().mapToInt(Integer::intValue).max().getAsInt();
        int index = list.indexOf(val) + 1;
        bw.write(val + "\n" + index);
        bw.flush();
        br.close();
        bw.close();
    }
}
