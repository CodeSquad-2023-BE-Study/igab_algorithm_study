package doit.ch07.boj2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2606_바이러스 {
    static int[][] map;
    static boolean[] visit;
    static int M;
    static int N;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[M + 1][M + 1];
        visit = new boolean[M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        bfs(1);
        System.out.println(cnt);
    }

    private static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        visit[idx] = true;
        // 2 5
        // 5 3
        // 3 6
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 1; i <= M; i++) {
                if (map[i][poll] == 1 && map[poll][i] == 1 && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                    cnt++;
                }
            }
        }
    }
}
