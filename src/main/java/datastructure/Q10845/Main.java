package datastructure.Q10845;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        int last = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    last = Integer.valueOf(st.nextToken());
                    q.offer(last);
                    break;
                case "pop": bw.write((q.size() == 0 ? -1 : q.poll()) + "\n"); break;
                case "size": bw.write(q.size() + "\n"); break;
                case "empty": bw.write((q.size() == 0 ? 1 : 0) + "\n"); break;
                case "front": bw.write((q.size() == 0 ? -1 : q.peek()) + "\n"); break;
                case "back": bw.write((q.size() == 0 ? -1 : last) + "\n"); break;
                default: break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
