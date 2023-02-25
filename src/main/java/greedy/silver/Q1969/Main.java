package greedy.silver.Q1969;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = br.readLine();

        StringBuilder answer = new StringBuilder();
        char ch = ' ';
        int cnt = 0;
        int max;
        for (int i = 0; i < m; i++) {
            max = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++)
                map.put(arr[j].charAt(i), map.getOrDefault(arr[j].charAt(i),0)+1);

            List<Character> keySetList = new ArrayList<>(map.keySet());
            Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
            for (Character key : keySetList) {
                int value = map.get(key);
                if (max < value) {
                    max = value;
                    ch = key;
                } else if (max == value) {
                    char temp = key;

                    int num1 = Character.getNumericValue(ch);
                    int num2 = Character.getNumericValue(temp);

                    if (num1 > num2)
                        ch = temp;
                }
            }
            cnt += n - max;
            answer.append(ch);
        }

        System.out.println(answer);
        System.out.println(cnt);
    }
}
