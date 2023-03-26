package doit.ch06.boj11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11724_연요소의개수 {
    static boolean[] visit;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        int cnt = 0;
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int idx) {
        if (visit[idx]) {
            return;
        } else {
            visit[idx] = true;
            for (int i = 0; i < visit.length; i++) {
                dfs(i);
            }
        }
    }
}
