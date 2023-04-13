package doit.이진탐색.boj1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1920길찾 {
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
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(Integer.parseInt(st.nextToken()), 0, N - 1)).append("\n");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int num, int low, int high) {
        if (low > high) {
            return 0;
        }

        int mid = (low + high) / 2;
        if (arr[mid] == num) {
            return 1;
        } else if (arr[mid] < num) {
            return binarySearch(num, mid + 1, high);
        } else {
            return binarySearch(num, low, mid - 1);
        }
    }
}
