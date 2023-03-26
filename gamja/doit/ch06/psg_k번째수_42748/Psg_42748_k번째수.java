package doit.ch06.psg_k번째수_42748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Psg_42748_k번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }
        //  System.out.println(Arrays.toString(arr));
        //TODO
        // A와 B의 길이가 다르면, 짧은 것이 먼저 온다. ->오름차순
        // 만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다) -> 오름차순
        // 만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다. -> 오름차순
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() == o2.length()) {
                    String o1Int = (o1.replaceAll("[^0-9]", ""));
                    String o2Int = (o2.replaceAll("[^0-9]", ""));
                    int hap1 = hap(o1Int);
                    int hap2 = hap(o2Int);
                    if (hap1 == hap2) {
                        return o1.compareTo(o2);
                    } else {
                        return Integer.compare(hap1, hap2);
                    }
                } else {
                    return -1;
                }
            }

            private int hap(String num) {
                int sum = 0;
                for (int i = 0; i < num.length(); i++) {
                    sum += Integer.parseInt(String.valueOf(num.charAt(i)));
                }
                return sum;
            }
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
