package doit.ch07.타겟넘버;

public class 타겟넘버 {
    //TODO 들어오는 배열을 모두 더해보고 빼보는걸 계속해본다?
    int answer = 0;
    int target = 0;
    int[] arr;

    public int solution(int[] arr, int target) {
        this.target = target;
        this.arr = arr;
        dfs(0, 0);
        return answer;
    }

    private void dfs(int idx, int sum) {
        //종료조건
        if (this.arr.length == idx) { //
            if (sum == target) {
                answer++;
            }
            return;
        }
        //재귀
        dfs(idx + 1, sum + arr[idx]);
        dfs(idx + 1, sum - arr[idx]);
    }
}
