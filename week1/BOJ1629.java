package da2sy.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {
    public static long cal(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }
        long temp = cal(a, b / 2, c);
        if (b % 2 == 1) {
            return ((temp * temp) % c * a) % c;
        } else {
            return (temp * temp) % c;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long result = cal(A, B, C);
        System.out.print(result);
    }
}
