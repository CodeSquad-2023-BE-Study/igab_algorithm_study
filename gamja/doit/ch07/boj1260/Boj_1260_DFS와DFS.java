package doit.ch07.boj1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1260_DFS와DFS {
    static int[][] map;
    static boolean[] visit;
    static int a;
    static int b;
    static int c;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.valueOf(st.nextToken());
        b = Integer.valueOf(st.nextToken());
        c = Integer.valueOf(st.nextToken());

        map = new int[a + 1][a + 1];
        visit = new boolean[a + 1];
        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.valueOf(st.nextToken());
            int num2 = Integer.valueOf(st.nextToken());

            map[num1][num2] = map[num2][num1] = 1;
        }

        visit[c] = true;
        dfs(c);
        System.out.println(sb);
        sb = new StringBuilder();
        visit = new boolean[a + 1];
        bfs(c);
        System.out.println(sb);
    }

    private static void dfs(int inx) {
        visit[inx] = true;
        sb.append(inx).append(" ");
        for (int i = 1; i <= a; i++) {
            if (map[inx][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int inx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(inx);
        visit[inx] = true;
        sb.append(inx).append(" ");

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int j = 1; j <= a; j++) {
                if (map[poll][j] == 1 && !visit[j]) {
                    visit[j] = true;
                    queue.add(j);
                    sb.append(j).append(" ");
                }
            }
        }
    }
}
