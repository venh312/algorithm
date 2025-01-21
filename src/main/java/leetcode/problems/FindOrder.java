/*
https://leetcode.com/problems/course-schedule-ii/

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
*/
class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 각 과목에 대한 진입 차수 (indegree) 배열
        int[] indegree = new int[numCourses];
        // 각 과목에 연결된 후속 과목을 저장하는 인접 리스트
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // 그래프 초기화 및 진입 차수 계산
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int pre = prereq[1];
            adjList.putIfAbsent(pre, new ArrayList<>());
            adjList.get(pre).add(course);
            indegree[course]++; // 진입 차수 증가
        }

        // 진입 차수가 0인 과목들을 큐에 추가
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 결과를 저장할 리스트
        List<Integer> order = new ArrayList<>();

        // 위상 정렬 수행
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current); // 현재 과목을 순서에 추가

            // 현재 과목의 후속 과목들에 대해 진입 차수 감소
            if (adjList.containsKey(current)) {
                for (int next : adjList.get(current)) {
                    indegree[next]--;
                    // 진입 차수가 0이 된 과목을 큐에 추가
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        // 모든 과목을 순서에 추가할 수 없다면 빈 배열 반환
        if (order.size() != numCourses) {
            return new int[0];
        }

        // 결과 반환
        return order.stream().mapToInt(i -> i).toArray();
    }
}
