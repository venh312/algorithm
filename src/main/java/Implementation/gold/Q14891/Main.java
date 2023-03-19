package Implementation.gold.Q14891;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static String[][] arr = new String[5][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < 5; i++)
            arr[i] = br.readLine().split("");
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            rotate(no, direction, true, true);
        }
        int a = arr[1][0].equals("0") ? 0 : 1;
        int b = arr[2][0].equals("0") ? 0 : 2;
        int c = arr[3][0].equals("0") ? 0 : 4;
        int d = arr[4][0].equals("0") ? 0 : 8;
        bw.write(a + b + c + d + "");
        bw.flush();
        br.close();
        bw.close();
    }

    static void rotate(int no, int direction, boolean left, boolean right) {
        int leftNo = no - 1;
        int rightNo = no + 1;
        if (leftNo > 0 && left)
            if (!arr[no][6].equals(arr[leftNo][2]))
                if (direction > 0)
                    rotate(leftNo, -1, true, false);
                else
                    rotate(leftNo, 1, true, false);
        if (rightNo < 5 && right)
            if (!arr[no][2].equals(arr[rightNo][6]))
                if (direction > 0)
                    rotate(rightNo, -1, false, true);
                else
                    rotate(rightNo, 1, false, true);
        int maxIndex = 7;
        String tmp = arr[no][maxIndex];
        if (direction < 0) tmp = arr[no][0];
        for (int i = 0; i < maxIndex; i++)
            if (direction > 0)
                arr[no][maxIndex - i] = arr[no][(maxIndex - i) - 1];
            else
                arr[no][i] = arr[no][i+1];
        if (direction > 0)
            arr[no][0] = tmp;
        else
            arr[no][maxIndex] = tmp;
    }
}
