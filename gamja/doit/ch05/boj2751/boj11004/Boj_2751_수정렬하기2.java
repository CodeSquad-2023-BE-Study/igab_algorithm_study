package doit.ch05.boj2751.boj11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 왼쬑 피벗 기준
 */
public class Boj_2751_수정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Boj_2751_수정렬하기2 b = new Boj_2751_수정렬하기2();
        int[] ints = b.quickSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i : ints) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
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

