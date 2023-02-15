package greedy.silver.Q10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  bf = new BufferedReader(new InputStreamReader(System.in));
        char[] tmp = bf.readLine().toCharArray();
        int[] arr = new int[tmp.length];

        for (int i = 0; i < tmp.length ; i++)
            arr[i]=tmp[i]-'0';

        boolean isThirth = false;
        int sum = 0;

        for (int i = 0; i <arr.length ; i++) {
            sum += arr[i];
            if (arr[i] == 0)
                isThirth = true;
        }

        if (sum %3 !=0 | !isThirth)
            System.out.println(-1);
        else {
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            for (int i = arr.length-1; i >=0 ; i--)
                sb.append(arr[i]);
            System.out.println(sb.toString());
        }
    }
}
