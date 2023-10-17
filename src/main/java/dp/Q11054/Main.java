import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] increasingDp = new int[N];
        int[] decreasingDp = new int[N];

        for (int i = 0; i < N; i++) {
            increasingDp[i] = 1;
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j] && increasingDp[i] < increasingDp[j] + 1)
                    increasingDp[i] = increasingDp[j] + 1;
        }

        for (int i = N - 1; i >= 0; i--) {
            decreasingDp[i] = 1;
            for (int j = N - 1; j > i; j--)
                if (arr[i] > arr[j] && decreasingDp[i] < decreasingDp[j] + 1)
                    decreasingDp[i] = decreasingDp[j] + 1;
        }

        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            int combinedLength = increasingDp[i] + decreasingDp[i] - 1;
            if (combinedLength > maxLength)
                maxLength = combinedLength;
        }

        System.out.println(maxLength);
    }
}
