package greedy.silver.Q1213;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String answer = "";

        int[] alph = new int[26];
        for (int i = 0; i < str.length(); i++)
            alph[str.charAt(i) - 'A'] += 1;

        int mid = -1;
        int valid = 0;
        for (int i = 0; i < alph.length; i++) {
            if (valid > 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
            if (alph[i] % 2 != 0) {
                ++valid;
                mid = i;
            }
        }

        for (int i = 0; i < alph.length; i++) {
            int val = alph[i];
            if (val == 0) continue;
            for (int j = 0; j < val / 2; j++)
                answer += (char) (i + 'A');
        }

        String reverseStr = new StringBuffer(answer).reverse().toString();
        String midStr = mid > -1 ? String.valueOf((char) (mid + 'A')) : "";

        System.out.println(answer + midStr + reverseStr);
    }
}
