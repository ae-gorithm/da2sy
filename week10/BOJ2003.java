package da2sy.week10;

/*
* [투 포인터] + [구간합]
* 왼쪽 포인터와 오른쪽 포인터를 설정하여 구간의 합을 구함
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0, count = 0;

        while(end <= n) {
            if(sum < m) {
                sum += arr[end++];
            } else if (sum == m) {
                count++;
                sum += arr[end++];
            } else {
                sum -= arr[start++];
            }
        }
        System.out.print(count);
    }
}
