/* Number of Provinces
https://leetcode.com/problems/number-of-provinces/description/

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
and city b is connected directly with city c, then city a is connected indirectly with city c.
n개의 도시가 있습니다. 그중 일부는 연결되어 있고, 일부는 연결되어 있지 않습니다.
도시 a가 도시 b와 직접 연결되어 있고, 도시 b가 도시 c와 직접 연결되어 있다면, 도시 a는 도시 c와 간접적으로 연결되어 있습니다.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.
지방은 직간접적으로 연결된 도시들의 집합이며, 그 집합 외부에는 다른 도시가 없습니다.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
n x n 행렬 isConnected가 주어집니다. 여기서 i번째 도시와 j번째 도시가 직접 연결되어 있으면 isConnected[i][j] = 1이고, 그렇지 않으면 isConnected[i][j] = 0입니다.

Return the total number of provinces.

Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 */
class FindCircleNum {
    private boolean[] visited;
    int rows, cols;
    public int findCircleNum(int[][] isConnected) {
        rows = isConnected.length;
        cols = isConnected[0].length;

        visited = new boolean[cols];

        int findCircleNumResult = 0;
        for (int i = 0;  i < cols; i++) {
            if (!visited[i]) {
                findCircleNumResult++;
                findCircleNumDFS(isConnected, i);
            }
        }

        return findCircleNumResult;
    }

    private void findCircleNumDFS(int[][] isConnected, int v) {
        visited[v] = true;
        for (int i = 0; i < cols; i++) {
            if (isConnected[v][i] == 1 && !visited[i]) {
                findCircleNumDFS(isConnected, i);
            }
        }
    }
}
