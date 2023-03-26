package doit.ch06.boj10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj_10809_수정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] count = new int[10001];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i < count.length; i++) {
            while (count[i] > 0) {
                sb.append(i+"\n");
                count[i]--;
            }
        }
        System.out.println(sb);

//        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
////실험할 코드 추가
//        ArrayList list = new ArrayList(10000000);
//        for (int i = 0; i < 10000000; i++) {
//            // int n = (int) (Math.random()*1000000);
//            list.add(i);
//        }
//
//        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
//        long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
//        System.out.println("시간차이(m) : " + secDiffTime);
//
//        Runtime.getRuntime().gc();
//        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//        System.out.print(usedMemory + " bytes");  //메모리 확인
    }
}
