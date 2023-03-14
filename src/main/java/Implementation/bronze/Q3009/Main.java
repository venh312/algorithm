package Implementation.bronze.Q3009;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> leftMap = new HashMap<>();
        HashMap<String, Integer> rightMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            String[] arr = br.readLine().split(" ");
            leftMap.put(arr[0], leftMap.getOrDefault(arr[0], 0) + 1);
            rightMap.put(arr[1], rightMap.getOrDefault(arr[1], 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : leftMap.entrySet())
            if (entry.getValue() == 1)
                bw.write(entry.getKey() + " ");
        for (Map.Entry<String, Integer> entry : rightMap.entrySet())
            if (entry.getValue() == 1)
                bw.write(entry.getKey() + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
