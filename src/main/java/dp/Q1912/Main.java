
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());

        int maxEnding = nums[0]; // 현재까지의 부분합
        int max = nums[0]; // 최대 부분합
        for (int i = 1; i < n; i++) {
            // 이전까지의 부분합과 현재 숫자를 더한 값 중에서 더 큰 값을 선택
            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            // 최대 부분합을 업데이트
            max = Math.max(max, maxEnding);
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
        br.close();
    }
}
