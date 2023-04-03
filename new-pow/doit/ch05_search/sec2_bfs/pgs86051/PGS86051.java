package doit.ch05_search.sec2_bfs.pgs86051;

import java.util.stream.IntStream;

class PGS86051 {
    public int solution(int[] numbers) {
        int answer = IntStream.range(0, 10).sum();
        for (int n : numbers) { answer-=n; }
        return answer;
    }
}
