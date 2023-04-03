package doit.이진탐색.psgLv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 제일작은수제거하기lv1 {
    public int[] solution(int[] arr) {
        int[] answer = new int[1];
        if (arr.length == 1) {
            answer[0] = -1;
            return answer;
        }
        int min = Arrays.stream(arr).min().orElseThrow();
        int[] toArray = Arrays.stream(arr).filter(i -> i != min).toArray();
        return toArray;
    }

    public static void main(String[] args) {
        제일작은수제거하기lv1 m = new 제일작은수제거하기lv1();
        System.out.println(Arrays.toString(m.solution(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(m.solution(new int[]{-1})));
    }
}
