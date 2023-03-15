package doit.ch05.boj11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        System.out.println(ints[n]);
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
        pivotSort(arr, left, pivot - 1);
        pivotSort(arr, pivot + 1, right);
    }

    //분할

    public int partition(int[] arr, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = arr[left];  //맨 왼쪽을 피벗으로 지정 시작 지점

        while (lo < hi) {

            //피벗 보다 큰수
            while (pivot < arr[hi] && lo < hi) {
                hi--;
            }

            //피벗 보다 작은수
            while (pivot >= arr[lo] && lo < hi) {
                lo++;
            }
            //위의 두조건을 통과했다면 swap해야함
            swap(arr, lo, hi);
        }

        //마지막에 피봇의 위치와 lo위치를 바꿔준다
        swap(arr, left, lo);
        return left; //피벗 위치 리턴
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
