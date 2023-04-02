package doit.ch06.boj11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_11724_연요소의개수 {
    static int[][] map;
    static boolean[] visit;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visit = new boolean[1001];
        map = new int[1001][1001];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //노드들은 방향성이없다
            map[a][b] = 1;
            map[b][a] = 1;
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int node) {
        if (visit[node]) {
            return;
        }
        visit[node] = true;
        //현재노드에서 아직 탐색하지않은 노드를 탐색한다 노드는 양방향성을 가진다
        for (int i = 1; i <= N; i++) {
            if(map[node][i] == 1) {
                dfs(i);
            }
        }
    }
}
