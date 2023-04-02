package doit.ch05_search.sec2_bfs.boj1260;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

// 메모리 초과
// 아마도 스택오버플로어
public class BOJ1260 {
    private static Queue<Integer> q = new LinkedList<>();
    private static boolean[][] map;
    private static boolean[] visit;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        map = new boolean[n+1][n+1];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = true;
        }

        visit = new boolean[n+1];
        visit[0] = true;
        visit[v] = true;

        dfs(v, sb);

        sb.append("\n");

        visit = new boolean[n+1];
        visit[0] = true;

        bfs(v, sb);

        System.out.println(sb.toString().trim());
        br.close();
    }

    private static void dfs(int v, StringBuilder sb) throws Exception {
        sb.append(v+" ");
        visit[v] = true;

        for (int i=0; i<map.length; i++) {
            int nv = i;
            if (nv > 0 && nv < visit.length && map[v][nv] && !visit[nv]) {
                dfs(nv, sb);
            }
        }
    }

    private static void bfs(int v, StringBuilder sb) throws Exception {
        q = new LinkedList<>();
        visit[v] = true;
        q.add(v);

        while (!q.isEmpty()) {
            int num = q.poll();
            sb.append(num + " ");
            for(int i = 1 ; i < map.length ; i++) {
                if(map[num][i] && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}
