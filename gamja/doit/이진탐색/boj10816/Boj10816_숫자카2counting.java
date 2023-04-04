package doit.이진탐색.boj10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj10816_숫자카2counting {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] countArr = new int[20000001];

        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i] + 10000000]++;
        }

        for (int i = 0; i < M; i++) {
            sb.append(countArr[Integer.valueOf(st.nextToken()) + 10000000]).append(" ");
        }
        System.out.println(sb);
    }
}
