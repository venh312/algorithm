package greedy.bronze.Q2810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String seat = br.readLine();
        seat = seat.replace("LL","*LL*");
        seat = seat.replace("S","*S*");
        seat = seat.replace("**","*");
        int cnt = seat.replaceAll("S|L","").length();
        System.out.println(Math.min(cnt, n));
    }
}
