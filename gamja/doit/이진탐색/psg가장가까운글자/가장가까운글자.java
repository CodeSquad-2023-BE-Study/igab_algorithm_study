package doit.이진탐색.psg가장가까운글자;

import java.util.Arrays;

public class 가장가까운글자 {
    static char[] charArray;

    public int[] solution(String s) {
        int[] answer = {};
        charArray = s.toCharArray();

        int[] arr = new int[charArray.length];
        Arrays.fill(arr, -1);
        arr[0] = -1;
        // [-1,-1,-1,1,2,3]
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == charArray[j]) {
                    //준 인덱스를 넘지 않는 가장 가까운 위치 = 기준 인덱스 - 비교 인덱스의 최대값
                    //banana
                    //   System.out.println("i = " + i);
                    //   System.out.println(s.substring(0, i));
                    //   System.out.println(s.substring(0, i).lastIndexOf(charArray[j]));
                    arr[i] = i - s.substring(0, i).lastIndexOf(charArray[j]);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        가장가까운글자 m = new 가장가까운글자();
        System.out.println(m.solution("banana"));
    }
}
