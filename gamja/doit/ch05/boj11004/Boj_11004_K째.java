package doit.ch05.boj11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 피벗 가운데 정렬
 */
public class Boj_11004_K째 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Boj_11004_K째 b = new Boj_11004_K째();
        int[] ints = b.quickSort(arr);
        System.out.println(ints[n - 1]);
    }

    public int[] quickSort(int[] arr) {
        pivotSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void pivotSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        //피봇을 기준으로 분할
        pivotSort(arr, left, pivot);
        pivotSort(arr, pivot + 1, right);
    }

    //분할
    public int partition(int[] arr, int left, int right) {
        int lo = left - 1;
        int hi = right + 1;
        int pivot = arr[(left + right) / 2];  //맨 왼쪽을 피벗으로 지정 시작 지점

        while (true) {

            do {
                lo++;
            } while (pivot > arr[lo]);
            //피봇보다 작은 경우 반복 -> 이쪽 영역에서 숫자가 피봇보다 크면 스왑해야함

            do {
                hi--;
            } while (arr[hi] > pivot && lo <= hi);
            //피봇보다 큰 경우 반복  -> 이쪽 영역에서 숫자가 피봇보다 작으면 스왑해야함

            if (lo >= hi) {
                return hi;
            }
            // 두포인트가 같거나 lo가 더 커지면 그 포인트를 리턴해야함 ->  hi 포인트가 더 뒤로가짐

            //위의 두조건을 통과했다면 swap해야함
            swap(arr, lo, hi);
        }
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
