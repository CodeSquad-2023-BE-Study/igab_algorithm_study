package doit.ch05.boj11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            map.put(i, Integer.valueOf(st.nextToken()));
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o1).compareTo(map.get(o2)));
        //mergeSort(arr, 0, arr.length - 1);
        System.out.println(keySet);
        int sum = 0;
        int prsum = 0;
        for (int i = 0; i < keySet.size(); i++) {
            prsum += map.get(keySet.get(i));
            sum += prsum;
            System.out.println(prsum);
        }
        System.out.println(sum);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            //정복
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            //병합;
            merge(arr, left, middle, right);
        }
    }

    // 정렬된 두개의 배열을 merge하여 하나의 배열로 만든다.
    private static void merge(int[] arr, int left, int middle, int right) {
        int[] tmp = new int[arr.length];
        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            }
        }
    }
}

