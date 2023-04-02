package W5.없는숫자더하기;

class Solution {
    public int solution(int[] numbers) {
        int[] one2Ten = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for(int i : numbers) {
            one2Ten[i] = 0;
        }

        int sum = 0;
        for(int i : one2Ten) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1,2,3,4,6,7,8,0}));

    }
}
