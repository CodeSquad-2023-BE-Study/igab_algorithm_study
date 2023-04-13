package doit.이진탐색.boj10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj10816_숫자카2 {
    static int[] arr;
    static int N;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.valueOf(st.nextToken());
            sb.append(upperBound(target, arr) - lowerBound(target, arr)).append(" ");
        }
        System.out.println(sb);
    }

    //   6 3 2 10 10 10 10 -10 7 3 1
    //
//     low   hight     7
    ///    low
    //    end
    static int lowerBound(int target, int[] arr) { //10 10 10 10 10 10
        int low = 0;
        int high = arr.length - 1;
//
        while (arr[low] < arr[high]) {
            int mid = (low + high) / 2;
            if (target <= arr[mid]) {
                high = mid;
            } else {
                low = 1 + mid;
            }
        }
        return low;
    }

    //이게
    static int upperBound(int target, int[] arr) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (target < arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
