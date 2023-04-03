package doit.ch05_search.sec2_bfs.boj2606;

import java.io.*;
import java.util.*;

public class BOJ2606 {
    private static boolean[][] computers;
    private static boolean[] visit;
    private static Queue<Integer> queue;
    private static int result = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // computer num
        int m = Integer.parseInt(br.readLine());

        computers = new boolean[n+1][n+1];
        visit = new boolean[n+1];
        visit[0] = true;
        queue = new LinkedList<>();

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers[a][b] = computers[b][a] = true;
        }

        queue.add(1);
        visit[1] = true;
//1
        // 2 5
        // 5 3
        //3 6
        while (!queue.isEmpty()) {
            int computer = queue.poll();

            for (int j=0; j<=n; j++) {
                int newComputer = j;


                if (newComputer <1 || newComputer > n) continue;
                if (computers[computer][newComputer] && !visit[newComputer]) {
                    visit[newComputer] = true;
                    queue.add(newComputer);
                }
            }
        }

        for (int j=1; j<=n; j++) {
            if (visit[j]) result ++;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
