package doit.ch06.boj_1431_시리얼번호;

import java.util.Arrays;

public class Boj_1431_시리얼번호 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int find = commands[i][2] - 1;
            int[] copy = Arrays.copyOfRange(array, start, end);
            Arrays.sort(copy);
            answer[i] = copy[find];
        }
        return answer;
    }
}
