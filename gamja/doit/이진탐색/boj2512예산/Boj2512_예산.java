package doit.이진탐색.boj2512예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2512_예산 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int sumArr = 0;
        for (int money : arr) {
            sumArr += money;
        }

        int allBudget = Integer.parseInt(br.readLine());

        int low = 0;
        int high = allBudget;
        int result = 0;

        if (sumArr <= allBudget) {
            System.out.println(arr[arr.length - 1]);
            return;
        }

        while (low <= high) {

            int mid = (low + high) / 2;
            int sum = 0;

            for (int money : arr) {
                if (money >= mid) {
                    sum += mid;  //모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
                } else {
                    sum += money;  // 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다
                }
            }
            if (sum > allBudget) {
                high = mid - 1;
            } else {
                low = mid + 1;
                result = Math.max(mid, result);
            }
        }
        System.out.println(result);
    }
}
