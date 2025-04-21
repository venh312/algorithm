/*
https://leetcode.com/problems/task-scheduler/description/

621. Task Scheduler
You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n.
CPU 작업 배열이 주어지며, 각 작업에는 A에서 Z까지의 문자와 숫자 n이 표시됩니다.

Each CPU interval can be idle or allow the completion of one task.
각 CPU 간격은 유휴 상태이거나 하나의 작업을 완료할 수 있습니다

Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.
작업은 어떤 순서로든 완료할 수 있지만, 동일한 레이블을 가진 두 작업 사이에 최소 n 간격의 간격이 있어야 한다는 제약이 있습니다.

Return the minimum number of CPU intervals required to complete all tasks.
모든 작업을 완료하는 데 필요한 최소 CPU 간격을 반환합니다.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
After completing task A, you must wait two intervals before doing A again.
The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.
작업 A를 완료한 후에는 A를 다시 수행하기 전에 두 간격을 기다려야 합니다. 작업 B에도 동일하게 적용됩니다.
세 번째 간격에서는 A도 B도 할 수 없으므로 유휴 상태가 됩니다. 네 번째 간격까지는 2 간격이 지났기 때문에 다시 A를 할 수 있습니다.

Example 2:
Input: tasks = ["A","C","A","B","D","B"], n = 1
Output: 6
Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
With a cooling interval of 1, you can repeat a task after just one other task.
냉각 간격이 1인 경우, 한 가지 다른 작업만 수행한 후에도 작업을 반복할 수 있습니다.

Example 3:
Input: tasks = ["A","A","A", "B","B","B"], n = 3
Output: 10
Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.

Example 4:
Input: tasks = ["A","A"], n = 3
Output: 5
Explanation: A possible sequence is: A -> idle -> idle -> idle -> A.
*/
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }

        Arrays.sort(counts); // 빈도 기준으로 정렬 (오름차순)
        int maxCount = counts[25]; // 가장 많이 등장한 작업의 수

        int slots = (maxCount - 1) * (n + 1); // 블록 수 * 각 블록의 길이
        int sameMax = 1;

        // maxCount와 같은 빈도를 가진 작업 수 확인
        for (int i = 24; i >= 0; i--) {
            if (counts[i] != maxCount) break;
            sameMax++;
        }

        // 최종 간격 계산
        return Math.max(tasks.length, slots + sameMax);
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        char[] tasks1 = {'A','A','A','B','B','B'};
        int n1 = 2;
        System.out.println(ts.leastInterval(tasks1, n1)); // 출력: 8
    }
}
