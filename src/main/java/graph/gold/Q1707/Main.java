package graph.gold.Q1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    static int[] checked;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        // 테스트 케이스 만큼 반복
        for (int i = 0; i < K; i++) {
            String[] graphInfo = br.readLine().split(" ");
            int V = Integer.parseInt(graphInfo[0]);
            int E = Integer.parseInt(graphInfo[1]);
            adjList = new ArrayList[V+1];
            visited = new boolean[V+1];
            checked = new int[V+1];
            isEven = true;

            for (int n = 1; n <= V; n++)
                adjList[n] = new ArrayList<>();

            for (int j = 0; j < E; j++) {
                graphInfo = br.readLine().split(" ");
                int start = Integer.parseInt(graphInfo[0]);
                int end = Integer.parseInt(graphInfo[1]);
                adjList[start].add(end);
                adjList[end].add(start);
            }

            for (int k = 1; k <= V; k++) {
                if (isEven)
                    DFS(k);
                else
                    break;
            }

            if (isEven)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    static void DFS(int start) {
        visited[start] = true;
        for (Integer i : adjList[start]) {
            if (!visited[i]) {
                checked[i] = (checked[start] + 1) % 2;
                DFS(i);
            } else if(checked[start] == checked[i]) {
                isEven = false;
            }
        }
    }

}
