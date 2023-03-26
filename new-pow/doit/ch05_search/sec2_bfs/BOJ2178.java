package doit.ch05_search.sec2_bfs;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2178 {
    private static Deque<int[]> deque;  // 의외로 여기서 타입 지정하는게 제일 힘들었다.
    private static char[][] graph;      // 그래프 저장
    private static int[][] path;        // 최단거리 계산
    private static boolean[][] visit;   // 방문기록
    private static int[] moveX = {1, -1, 0, 0};
    private static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 100 * 100이 최대
        deque = new LinkedList();
        visit = new boolean[n][m];

        graph = new char[n][m];
        path = new int[n][m];
        path[0][0] = 1;

        for (int i=0; i<n; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        // 목표지점 n-1, m-1
        bfs(0, 0);

        bw.write(path[n-1][m-1]+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int a, int b) {
        deque.add(new int[] {a,b});

        while(!deque.isEmpty()) {
            int[] on = deque.poll();
            int x = on[1];  // 변수 설정
            int y = on[0];
            visit[y][x] = true;

            for (int k=0; k<moveX.length; k++) {
                int nY = on[0] + moveY[k];
                int nX = on[1] + moveX[k];

                if(0 > nX || 0 > nY || graph[0].length <= nX || graph.length <= nY) continue;   // 여기서 2번정도 변수 설정 실수

                if (!visit[nY][nX] && graph[nY][nX] == '1') {
                    deque.add(new int[]{nY, nX});
                    path[nY][nX] = path[y][x] + 1;
                    visit[nY][nX] = true;           // 방문기록 반드시 업데이트 해줘야한다.
                }
            }
        }
    }
}
