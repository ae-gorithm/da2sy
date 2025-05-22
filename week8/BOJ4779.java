package da2sy.week8;

// 분할정복 알고리즘
// 1. 분할 : 비슷한 유형의 더 작은 하위 문제로 분할이 가능할 때까지 나눌 것
// 2. 재귀 : 각 하위 문제를 재귀적으로 해결할 것
// 3. 해결 : 해결한 하위 문제들을 통합하여 답을 얻을 것

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ4779 {
    static char[] cantorArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputStr;
        while ((inputStr = br.readLine()) != null) {
            int n = Integer.parseInt(inputStr);
            sb = new StringBuilder();
            int cantor = (int) Math.pow(3, n);
            cantorArr = new char[cantor];

            Arrays.fill(cantorArr, '-');
            divide(0, cantorArr.length);

            sb.setLength(0); // StringBuilder 초기화
            sb.append(cantorArr);
            System.out.println(sb);
        }
    }

    static void divide(int start, int end) {
        if (end - start < 3) return;

        int size = (end - start) / 3;
        for (int i = start + size; i < start + 2 * size; i++) {
            cantorArr[i] = ' ';
        }

        divide(start, start + size); // 왼쪽 1/3
        divide(start + 2 * size, end); // 오른쪽 1/3
    }
}