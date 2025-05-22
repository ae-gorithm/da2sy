package da2sy.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1449 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 물이 새는 곳의 개수
        int L = Integer.parseInt(st.nextToken());   // 테이프의 길이
        int minTape = 0;
        int[] waterZones = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < waterZones.length; i++) {
            waterZones[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(waterZones);

        int tapeRange = (int) (waterZones[0] - 0.5 + L);
        minTape++;

        for(int i = 1; i < waterZones.length; i++) {
            if(tapeRange < (int) (waterZones[i] + 0.5)) {
                tapeRange = (int) (waterZones[i] - 0.5 + L);
                minTape++;
            }
        }

        sb.append(minTape);
        System.out.print(sb);
    }
}
