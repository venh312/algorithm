package leetcode.learn;

public class MountainArray {
    public static void main(String[] args) {
        int[] arr = {0,3,2,1};
        int n = arr.length;
        int i = 0;

        // 산의 첫 부분에서 오름차순으로 진행
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // 산의 최고점에 도달하지 않으면 false 반환
        if (i == 0 || i == n - 1) {
            return false;
        }

        // 산의 끝 부분에서 내림차순으로 진행
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        // 산의 끝에 도달했는지 확인
        return i == n - 1;
    }
}
